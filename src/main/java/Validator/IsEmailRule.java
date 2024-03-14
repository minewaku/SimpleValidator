package Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import TypeCheck.StringChecker;

public class IsEmailRule extends BaseRule {
	
	private static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	Pattern pattern = Pattern.compile(EMAIL_REGEX);
	
	public IsEmailRule() {
		setErrorMessage("This field is not a valid email");
	}
	
	public IsEmailRule(String customMessage) {
		setErrorMessage(customMessage);
	}

	@Override
	public boolean process(Object data) throws ClassCastException {
		StringChecker checker = new StringChecker();
		if (checker.check(data)) {
			Matcher matcher = pattern.matcher((String) data);
			try {
				if(matcher.matches()) {
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
