package TypeCheck;

import java.util.ArrayList;
import java.util.List;

import Type.DoubleType;
import Type.FloatType;
import Type.IType;
import Type.IntegerType;
import Type.LongType;

public class NumberChecker {

	private List<IType> list = new ArrayList<IType>();
	
	public NumberChecker() {
		list.add(new IntegerType());
		list.add(new LongType());
		list.add(new FloatType());
		list.add(new DoubleType());
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
