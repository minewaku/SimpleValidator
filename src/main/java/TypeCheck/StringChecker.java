package TypeCheck;

import java.util.ArrayList;
import java.util.List;

import Type.IType;
import Type.StringType;

public class StringChecker {

	private List<IType> list = new ArrayList<IType>();
	
	public StringChecker() {
		list.add(new StringType());
	}


	public boolean check(Object data) {
		for(IType item : list) {
			if(item.check(data)) {
				return true;
				
			}
		}
		
		return false;
	}
}
