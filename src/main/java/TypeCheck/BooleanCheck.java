package TypeCheck;

public class BooleanCheck implements ITypeCheck {

	public boolean check(Object data) {
		if(data instanceof Boolean) {
			return true;
		}
		
		return false;
	}
}
