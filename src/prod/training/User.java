package prod.training;

import prod.training.Command;

public class User {								//Invoker
	
	Command start;
		
	public User(Command start) {
		this.start = start;
	}
		
	void startComputer() {
		start.execute();
	}
		
}
