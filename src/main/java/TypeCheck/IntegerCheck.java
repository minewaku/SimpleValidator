package TypeCheck;

public class IntegerCheck implements ITypeCheck {

	public boolean check(Object data) {
		if(data instanceof Integer) {
			return true;
		}
		
		return false;
	}
}
