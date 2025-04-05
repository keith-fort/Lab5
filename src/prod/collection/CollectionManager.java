package prod.collection;

import java.util.HashMap;
import java.util.Iterator;
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
        for (Route routeTemp : collection) {
            if (routeTemp.equals(route)) {
                inCollection = true;
                break;
            }
        }

        if (inCollection) {
        	consoleManager.printLine("Этот маршрут уже есть в коллекции.\n");
        } else {
            if (validator.getValid(route) != null){
                collection.add(route);
//                consoleManager.printLine("Маршрут успешно добавлен.\n");

                consoleManager.printLine("Маршрут успешно добавлен.\n");
            } else {
            	consoleManager.printLine("Параметры маршрута не верны.\n");
            }
//            consoleManager.printLine("Маршрут успешно добавлен.\n");
        }
		
	}

	public void remove_at(int index) {
		if (index < 0) {
			consoleManager.printLine("Индекс должен быть неотрицательным");
		}
		else if (index >= collection.size()) {
			consoleManager.printLine("В массиве нет элемента такого индекса");
		}
		else {
			collection.remove(index);
			consoleManager.printLine("Объект по индексу " + index + " удален. \n");
		}
	}
	
	public void insert_at(int index) {
		
		if (index < 0) {
			consoleManager.printLine("Индекс должен быть неотрицательным");
		}
		else if (index > collection.size()+1) {
			consoleManager.printLine("Индекс больше максимально допустимого");
		}
		else {
			Route route = routeManager.setRoute();
			collection.add(route);
			consoleManager.printLine("Объект добавлен в ячейку с индексом " + index + ".\n");
		}
		
	}
 	
	/**
     * Обновляет маршрут по ID. Заменяет старые данные новыми после валидации.
     * @param routeId ID маршрута для обновления
     * @param route Новые данные дракона
     */
	
    public void updateById(Long routeId) {
        boolean inCollection = false;
        Iterator<Route> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Route routeToRemove = iterator.next();
            
            if (routeToRemove.getId().equals(routeId)) {
                iterator.remove();
                
                Route route = routeManager.setRoute();
                
                route.setId(routeId);
                if (validator.getValid(route) != null) {
                    collection.add(route);
                } else {
                	consoleManager.printLine("Параметры маршрута не верны.\n");
                }
                inCollection = true;
                break;
            }
        }
        if (inCollection) {
        	consoleManager.printLine("Данные маршрута успешно обновлены.\n");
        } else {
        	consoleManager.printLine("Маршрута с ID " + routeId + " нет в коллекции.\n");
        }
    }
	
    public void removeById(Long routeId) {
    	
    	boolean del = false;
        Iterator<Route> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Route routeToRemove = iterator.next();
            
            if (routeToRemove.getId().equals(routeId)) {
                iterator.remove();
                consoleManager.printLine("Маршрут успешно удален.\n"); 
                del = true;
                break;
                
            }
        }
        if (del == false) {
        	consoleManager.printLine("Маршрута с ID " + routeId + " нет в коллекции.\n");
        }
           	
    }
    
	
	
}
