package prod.commands;

public interface Command {

//	void execute();
	
	void execute(String[] args);			
    String getDescription();
	
	
}
