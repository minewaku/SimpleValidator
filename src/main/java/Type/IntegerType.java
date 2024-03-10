package Type;

public class IntegerType implements IType {
	
	public boolean check(Object data) {
		if(data instanceof Integer) {
			return true;
		}
		
		return false;
	}
}
