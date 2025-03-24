package prod.commands;

import prod.baseClasses.Route;
import prod.collection.CollectionManager;

public class AddCommand implements Command{

	private CollectionManager collectionManager;
	
	public AddCommand(CollectionManager collectionManager) {
		this.collectionManager = collectionManager;
	}
	
	@Override
    public void execute(String[] args){
        if (args.length == 1) {
            try {
                Route route = collectionManager.getRouteManager().setRoute();
                collectionManager.add(route);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
	
	@Override
	public String getDescription() {
		return "add {element} : добавить новый элемент в коллекцию";
	}
	
}
