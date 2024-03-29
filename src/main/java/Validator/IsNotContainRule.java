package Validator;

import TypeCheck.StringChecker;

public class IsNotContainRule extends BaseRule {
	private String checkString = "";
	
	public IsNotContainRule(String checkString) {
		this.checkString = checkString;
		setErrorMessage("This field contains " + checkString + "!");
	}
	
	public IsNotContainRule(String customMessage, String checkString) {
		this.checkString = checkString;
		setErrorMessage(customMessage);
	}

	@Override
	public boolean process(Object data) throws ClassCastException {
		StringChecker checker = new StringChecker();
		if (checker.check(data)) {
			try {
				if(!((String) data).contains(checkString)) {
					return super.process(data);
				}
				else {
					super.setMessagePipe(errorMessage);
					return false;
				}
			} catch (ClassCastException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			super.setMessagePipe(getTypeCheckErrorMessage(this.getClass().getName(), data.getClass().getName()));
			return false;
		}
	}
}
