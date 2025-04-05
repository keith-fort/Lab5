package prod.commands;

import prod.collection.CollectionManager;

public class InsertAtIndexCommand implements Command{

CollectionManager collectionManager;
	
	public InsertAtIndexCommand(CollectionManager collectionManager) {
		this.collectionManager = collectionManager;
	}

	@Override	
	public void execute(String[] args) {
		
		if (args.length == 2) {
			try {
				int index = Integer.valueOf(args[1]);
				collectionManager.insert_at(index);
			} catch (NumberFormatException e){
				System.out.println("Ошибка. Введите число");
			}
        } else {
            throw new IllegalArgumentException();
        }
	}
	
	@Override
	public String getDescription() {
        return "insert_at index {element} : добавить новый элемент в заданную позицию";
	}
	
	
}
