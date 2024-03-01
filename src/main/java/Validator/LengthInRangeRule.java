package Validator;

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
	public Object process(Object data) throws ClassCastException {
		try {
			if(((String) data).length() >= min && ((String) data).length() <= max) {
				return super.process(data);
			}
			else {
				super.setMessagePipe(errorMessage);
				return false;
			}
			
		} catch(ClassCastException e) {
			e.printStackTrace();
			return e;
		}	
	}
}
