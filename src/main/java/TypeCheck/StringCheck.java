package TypeCheck;

public class StringCheck implements ITypeCheck {
	
	public boolean check(Object data) {
		if(data instanceof String) {
			return true;
		}
		
		return false;
	}
}
