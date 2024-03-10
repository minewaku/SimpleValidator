package Type;

public class BooleanType {

	public boolean check(Object data) {
		if(data instanceof Boolean) {
			return true;
		}
		
		return false;
	}
}
