package test;

import Validator.IsEmailRule;
import Validator.IsNotContainRule;
import Validator.IsNotEmptyRule;
import Validator.LengthInRangeRule;
import Validator.Validator;
import Validator.ValueInRangeRule;

public class Main {
	static public void main(String[] args) {
		String username = "minewaku@gmail.com";
		String password = "123";
		int arisuTheDaughter = 6;
		
//		Validator validator = new Validator();
//		validator.setRules(new IsNotEmptyRule(), 
//						   new LengthInRangeRule(5, 255), 
//						   new IsNotContainRule(password),
//						   new IsEmailRule());
		
//		Boolean result = validator.process(username);
		
		
		Validator validator1 = new Validator();
		validator1.setRules(new ValueInRangeRule(1, 5));
		Boolean result1 = validator1.process(password);
		
		if(result1) {
			System.out.println("Validate successfully!");
			System.out.println(validator1.getErrorMessage());
		}
		
		else {
			System.out.println(validator1.getErrorMessage());
		}
		
		System.out.println("Ket qua la: " + result1);
		
	}
}
