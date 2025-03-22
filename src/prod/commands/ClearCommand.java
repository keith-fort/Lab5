package prod.commands;

import prod.collection.CollectionManager;

public class ClearCommand implements Command{

	CollectionManager collectionManager;
	
	public ClearCommand(CollectionManager collectionManager) {
		this.collectionManager = collectionManager;
	}

	@Override	
	public void execute(String[] args) {
		
		if (args.length == 1) {
            collectionManager.clear();
        } else {
            throw new IllegalArgumentException();
        }
		
	}
	
	@Override
	public String getDescription() {
        return "clear : очистить коллекцию";
	}
	
}
