package prod.training;

import prod.training.Computer;

public class StartCommand implements Command{

	Computer computer;
	
	public StartCommand(Computer computer) {
		this.computer = computer;
	}
	@Override
	public void execute() {
		computer.start();
	}
	
}
