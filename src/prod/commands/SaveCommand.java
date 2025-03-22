package prod.commands;

import prod.collection.CollectionManager;

public class SaveCommand implements Command{

	CollectionManager collectionManager;
	
	public SaveCommand(CollectionManager collectionManager) {
		this.collectionManager = collectionManager;
	}

	@Override	
	public void execute(String[] args) {
		
		if (args.length == 1) {
            collectionManager.save();
        } else {
            throw new IllegalArgumentException();
        }
		
	}
	
	@Override
	public String getDescription() {
        return "save : сохранить коллекцию в файл";
	}
	
}
