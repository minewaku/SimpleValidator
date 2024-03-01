package Validator;

public class IsNotEmptyRule extends BaseRule {
	
	public IsNotEmptyRule() {
		setErrorMessage("This field is empty!");
	}
	
	public IsNotEmptyRule(String customMessage) {
		setErrorMessage(customMessage);
	}

	@Override
	public Object process(Object data) throws ClassCastException {
		try {
			if((String) data != "") {
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
