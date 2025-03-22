package prod.commands;

import prod.collection.CollectionManager;

public class HelpCommand implements Command{
	
	
	CollectionManager collectionManager;
		
	public HelpCommand(CollectionManager collectionManager) {
		this.collectionManager = collectionManager;
	}

	@Override	
	public void execute(String[] args) {
		
		if (args.length == 1) {
			CommandManager commandManager = collectionManager.getCommandManager();
            collectionManager.help(commandManager.getCommands());
        } else {
            throw new IllegalArgumentException();
        }
		
	}
	
	@Override
	public String getDescription() {
        return "help : вывести справку по доступным командам";
	}
	
}
