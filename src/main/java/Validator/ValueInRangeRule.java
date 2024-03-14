package Validator;

import TypeCheck.NumberChecker;

public class ValueInRangeRule extends BaseRule {
	private int min;
	private int max;

	public ValueInRangeRule(int min, int max) {
		this.min = min;
		this.max = max;
		setErrorMessage("This field's length must larger " + min + " and smaller " + max + "!");
	}

	public ValueInRangeRule(String customMessage, int min, int max) {
		this.min = min;
		this.max = max;
		setErrorMessage(customMessage);
	}

	@Override
	public boolean process(Object data) {
		NumberChecker checker = new NumberChecker();
		if (checker.check(data)) {
			try {
				Number number = (Number) data;
				if (number.doubleValue() >= min && number.doubleValue() <= max) {
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
