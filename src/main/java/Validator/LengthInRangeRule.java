package Validator;

import TypeCheck.StringChecker;

public class LengthInRangeRule extends BaseRule {
	private int min;
	private int max;
	
	public LengthInRangeRule(int min, int max) {
		this.min = min;
		this.max = max;
		setErrorMessage("This field's length must larger " + min + " and smaller " + max + "!"); 
	}
	
	public LengthInRangeRule(String customMessage, int min, int max) {
		this.min = min;
		this.max = max;
		setErrorMessage(customMessage);
	}

	@Override
	public boolean process(Object data) {
		StringChecker checker = new StringChecker();
		if (checker.check(data)) {
			try {
				String string = (String) data;
				if(string.length() >= min && string.length() <= max) {
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
