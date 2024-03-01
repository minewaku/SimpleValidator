package Validator;

public interface IRule {
	IRule setNext(IRule nextRule);        
    Object process(Object data);
	String getMessagePipe();
	void setMessagePipe(String messagePipe);
	void setErrorMessage(String customMessage);
}
