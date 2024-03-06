package Validator;

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
	public Object process(Object data) throws ClassCastException {
		
		try {
			if (data instanceof Number) {
	            Number number = (Number) data;
	            if (number.doubleValue() >= min && number.doubleValue() <= max) {
	                return super.process(data);
	            } else {
	                super.setMessagePipe(errorMessage);
	                return false;
	            }
	        } else {
	            throw new ClassCastException("Object cannot be cast to Number");
	        }
			
		} catch(ClassCastException e) {
			e.printStackTrace();
			return e;
		}	
	}
}
