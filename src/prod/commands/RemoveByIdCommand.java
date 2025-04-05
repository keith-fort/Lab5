package prod.commands;

import prod.collection.CollectionManager;
import prod.console.ConsoleManager;
import prod.console.RouteManager;

public class RemoveByIdCommand implements Command{

	private CollectionManager collectionManager;
    ConsoleManager consoleManager = new ConsoleManager();
    private RouteManager routeManager = new RouteManager(consoleManager);

    /**
     * Конструктор команды обновления
     * @param manager Менеджер коллекции для доступа к методам обновления
     */
    public RemoveByIdCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * @param args Аргументы команды (должен быть ровно 1 аргумент - ID)
     * @throws IllegalArgumentException Если:
     * <li>Количество аргументов неверное
     * <li>Аргумент ID не является числом
     */
	
	@Override
    public void execute(String[] args) {
        if (args.length == 2) {
            try {
                Long routeId = Long.parseLong(args[1]);
                collectionManager.removeById(routeId);
            } catch (NumberFormatException e) {
                System.out.println("ID должен быть числом.");
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
	
	@Override
	public String getDescription() {
		return "remove_by_id id : удалить элемент из коллекции по его id";
	}
	
}
