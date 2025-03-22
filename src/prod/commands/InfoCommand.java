package prod.commands;

import prod.collection.CollectionManager;

public class InfoCommand implements Command{

	CollectionManager collectionManager;
	
	public InfoCommand(CollectionManager collectionManager) {
		this.collectionManager = collectionManager;
	}

	@Override	
	public void execute(String[] args) {
		
		if (args.length == 1) {
//			CommandManager commandManager = collectionManager.getCommandManager();
            collectionManager.info();
        } else {
            throw new IllegalArgumentException();
        }
		
	}
	
	@Override
	public String getDescription() {
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
	}
	
}
