package Validator;

public abstract class BaseRule implements IRule {
	private IRule nextRule = null;
	private String messagePipe = ""; // errorMessage would be sent down through the pipe to the first IRule in the chain
	protected String errorMessage = ""; // contains default errorMessage for each IRule
	
	public IRule setNext(IRule nextRule) {
		this.nextRule = nextRule;
		return nextRule;
	}

	public Object process(Object data) throws ClassCastException {
		if (this.nextRule != null) {
			
			Boolean result = (Boolean) nextRule.process(data);
			if(result == false) {
				this.messagePipe = nextRule.getMessagePipe();
			}
			
			return result;
			
		} else {
			return true;
		}
	}

	//some how try to make them private, remove the interface IRule in the next update
	public String getMessagePipe() {
		return this.messagePipe;
	}
	
	public void setMessagePipe(String messagePipe) {
		this.messagePipe = messagePipe;
	}

	public void setErrorMessage(String customMessage) {
		this.errorMessage = customMessage;		
	}
}
