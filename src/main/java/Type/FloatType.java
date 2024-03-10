package Type;

public class FloatType implements IType {

	public boolean check(Object data) {
		if(data instanceof Float) {
			return true;
		}
		
		return false;
	}
}
