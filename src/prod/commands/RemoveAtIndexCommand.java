package prod.commands;

import prod.collection.CollectionManager;

public class RemoveAtIndexCommand implements Command{

	CollectionManager collectionManager;
	
	public RemoveAtIndexCommand(CollectionManager collectionManager) {
		this.collectionManager = collectionManager;
	}

	@Override	
	public void execute(String[] args) {
		
		if (args.length == 2) {
			try {
				int index = Integer.valueOf(args[1]);
				collectionManager.remove_at(index);
			} catch (NumberFormatException e){
				System.out.println("Ошибка. Введите число");
			}
        } else {
            throw new IllegalArgumentException();
        }
		/*
		if (args.length == 2) {
//			CommandManager commandManager = collectionManager.getCommandManager();
            collectionManager.remove_at(Integer.valueOf(args[1]));
        } else {
            throw new IllegalArgumentException();
        }
		*/
	}
	
	@Override
	public String getDescription() {
        return "remove_at index : удалить элемент, находящийся в заданной позиции коллекции (index)";
	}
	
}
