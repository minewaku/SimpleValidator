package Validator;

import TypeCheck.StringChecker;

public class IsNotEmptyRule extends BaseRule {
	
	public IsNotEmptyRule() {
		setErrorMessage("This field is empty!");
	}
	
	public IsNotEmptyRule(String customMessage) {
		setErrorMessage(customMessage);
	}

	@Override
	public boolean process(Object data) throws ClassCastException {
		StringChecker checker = new StringChecker();
		if (checker.check(data)) {
			try {
				if((String) data != "") {
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
