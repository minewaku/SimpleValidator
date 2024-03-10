package Type;

public class LongType implements IType {

	public boolean check(Object data) {
		if(data instanceof Long) {
			return true;
		}
		
		return false;
	}
}
