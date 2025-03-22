package prod.training;

import prod.training.Computer;
import prod.training.StartCommand;
import prod.training.User;

public class MN {

	public static void main(String[] args) {
		
		Computer comp = new Computer();
		StartCommand Start = new StartCommand(comp);
		
		User user = new User(Start);
		
		user.startComputer();

	}

}
