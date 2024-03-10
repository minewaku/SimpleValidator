package Type;

public class DoubleType implements IType {

	public boolean check(Object data) {
		if(data instanceof Double) {
			return true;
		}
		
		return false;
	}
}
