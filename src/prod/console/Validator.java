package prod.console;

import java.util.ArrayList;

import prod.baseClasses.Route;
import prod.collection.IdGenerator;

/**
 * Класс Validator отвечает за проверку корректности данных объекта Route.
 * Проверяет уникальность ID, корректность полей и типов данных.
 */

public class Validator {

	private ArrayList<Long> ids = new ArrayList<>();
    private IdGenerator idGen = new IdGenerator();
	
    /**
     * Проверяет уникальность ID маршрута.
     * Если ID уже существует, генерирует новый уникальный ID.
     * @param route Объект Route, который нужно проверить.
     * @return Объект Route с уникальным ID.
     */
    
    public Route getValidatedId(Route route) {
        Long id = route.getId();
        if (ids.contains(id)) {
            Long tmpId = idGen.generateId();
            System.out.println("ID маршрута " + route.getId() + " заменен на " + tmpId + " из-за коллизии.");
            route.setId(tmpId);
            ids.add(tmpId);
            return route;
        } else {
            ids.add(route.getId());
            return route;
        }
    }
       
    /**
     * Проверяет корректность всех полей объекта Route.
     * @param route Объект Route, который нужно проверить.
     * @return Объект Route, если все поля корректны, иначе null.
     */
    
    public Route getValid(Route route) {
    	
    	//return route;
    	
    	if (	route.getId() <= 0 || 
    			route.getName().isBlank() ||
    			route.getName().isEmpty() ||
    			route.getCoordinates() == null ||
    			route.getCreationDate() == null ||
    			route.getFrom() == null ||
    			route.getTo() == null ||
    			route.getDistance() == null || route.getDistance() <= 1 ||
    			route.getCoordinates().getY() > 618 ||
    			route.getTo().getName().isEmpty() || route.getTo().getName().isBlank()
    			
    			){
    		return null;
    	}
    	else {
    		return route;
    	}
    	
    	
    }
}