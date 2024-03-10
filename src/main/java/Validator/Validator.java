package Validator;

import java.util.ArrayList;
import java.util.List;

public class Validator {
	
	private List<IRule> rules = new ArrayList<IRule>();
	private String errorMessage = "";
	
	public void setRules(IRule... rules) {
		for(IRule item : rules) {
			this.rules.add(item);
		}
		
		chainGenerate();
	}
	
	private void chainGenerate() {
		
		if(rules.size() > 1) {
			for(int i = 0; i < rules.size() - 1; i++) {
				rules.get(i).setNext(rules.get(i + 1));
			}			
		}

	}
	
	public boolean process(Object data) {
		Boolean result = rules.get(0).process(data);
		this.errorMessage = rules.get(0).getMessagePipe();
		return result.booleanValue();
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}
}
