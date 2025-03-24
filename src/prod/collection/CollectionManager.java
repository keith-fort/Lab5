package prod.collection;

import java.util.HashMap;
import java.util.LinkedList;

import prod.baseClasses.Route;
import prod.commands.Command;
import prod.commands.CommandManager;
import prod.console.ConsoleManager;
import prod.console.RouteManager;
import prod.console.Validator;
import prod.file.FileManager;

public class CollectionManager {								//receiver
	
		
	LinkedList<Route> collection = new LinkedList<Route>();
	ConsoleManager consoleManager = new ConsoleManager();
	RouteManager routeManager = new RouteManager(consoleManager);
	Validator validator = new Validator();
	
	private CommandManager commandManager;
	private FileManager fileManager;
	
	private final java.time.LocalDateTime creationDate = java.time.LocalDateTime.now();
	
	
	public LinkedList<Route> getCollection() {
		return collection;
	}
	
	public void setCommandManager(CommandManager commandManager) {
		this.commandManager = commandManager;
	}
	
	public void setFileManager(FileManager fileManager) {
		this.fileManager = fileManager;
	}
	
	public CommandManager getCommandManager() {
		return commandManager;
	}
	
	public RouteManager getRouteManager() {
		return routeManager;	
	}
	
	
	public void show() {
        if (!collection.isEmpty()) {
            for (Route route : collection) {
            	consoleManager.printLine(route + "\n");
            }
        } else {
        	consoleManager.printLine("Коллекция пуста.\n");
        }
    }
	
	public void help(HashMap<String, Command> commands) {
		
		for (Command command : commands.values()) {
            consoleManager.printLine(command.getDescription() + "\n");
        }
		
	}
		
	public void info() {
		consoleManager.printLine("Тип хранимых данных в коллекции: Route\n");
		consoleManager.printLine("Дата и время инициализации: " + creationDate + "\n");
		consoleManager.printLine("Колличество элементов в коллеции: " + collection.size() + "\n");
    }
	
	public void clear() {
		collection.clear();
        consoleManager.printLine("Коллекция успешно удалена.\n");
	}
	
	public void save() {
		consoleManager.printLine("Коллекция сохранена в файл.\n");
		fileManager.loadToCSV(collection);
		
	}
	
	public void exit() {
		System.exit(0);
	}
	
	public void add(Route route) {
		
		boolean inCollection = false;
//		System.out.println("you are here");
        for (Route routeTemp : collection) {
            if (routeTemp.equals(route)) {
                inCollection = true;
                break;
            }
        }
//      System.out.println("you are here");
        if (inCollection) {
        	consoleManager.printLine("Этот маршрут уже есть в коллекции.\n");
        } else {
//        	System.out.println("you are here");
            if (validator.getValid(route) != null){
                collection.add(route);
//                consoleManager.printLine("Маршрут успешно добавлен.\n");
                System.out.println(collection);
            } else {
            	consoleManager.printLine("Параметры маршрута не верны.\n");
            }
            consoleManager.printLine("Маршрут успешно добавлен.\n");
        }
		
	}

	
	
	
	
	
	
	
}
