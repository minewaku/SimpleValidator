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
		String password1 = "minewaku";
		
		Validator validator = new Validator();
		validator.setRules(new IsNotEmptyRule(), 
						   new LengthInRangeRule(5, 255), 
						   new IsNotContainRule(password),
						   new IsEmailRule());
		
		boolean result = validator.process(username);

		if(result) {
			System.out.println("Validate succesfully!");
		}
		else { 
			System.out.println(validator.getErrorMessage());	
		}
		System.out.println("Result: " + result);
		
		
	}
}
