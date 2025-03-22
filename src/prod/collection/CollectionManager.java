package prod.collection;

import java.util.HashMap;
import java.util.LinkedList;

import prod.baseClasses.Route;
import prod.commands.Command;
import prod.commands.CommandManager;
import prod.console.ConsoleManager;
import prod.file.FileManager;

public class CollectionManager {								//receiver
	
		
	LinkedList<Route> collection = new LinkedList<Route>();
	ConsoleManager consoleManager = new ConsoleManager();
	
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
		consoleManager.printLine("Тип хранимых данных в коллекции: Dragon\n");
		consoleManager.printLine("Дата и время инициализации: " + creationDate + "\n");
		consoleManager.printLine("Колличество элементов в коллеции: " + collection.size() + "\n");
    }
	
	public void clear() {
		collection.clear();
        consoleManager.printLine("Коллекция успешно удалена.\n");
	}
	
	public void save() {
		fileManager.loadToCSV(collection);
	}
	
	public void exit() {
		System.exit(0);
	}
}
