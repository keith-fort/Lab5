package prod.commands;

import prod.collection.CollectionManager;

public class ExitCommand implements Command{

	CollectionManager collectionManager;
	
	public ExitCommand(CollectionManager collectionManager) {
		this.collectionManager = collectionManager;
	}

	@Override	
	public void execute(String[] args) {
		
		if (args.length == 1) {
            collectionManager.exit();
        } else {
            throw new IllegalArgumentException();
        }
		
	}
	
	@Override
	public String getDescription() {
        return "exit : завершить программу (без сохранения в файл)";
	}
	
}
