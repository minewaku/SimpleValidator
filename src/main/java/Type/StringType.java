package Type;

public class StringType implements IType {
	
	public boolean check(Object data) {
		if(data instanceof String) {
			return true;
		}
		
		return false;
	}
}
