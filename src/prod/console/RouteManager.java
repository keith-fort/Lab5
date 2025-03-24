package prod.console;

import prod.baseClasses.Coordinates;
import prod.baseClasses.Route;
import prod.baseClasses.Location;
import prod.baseClasses.LocationFrom;
import prod.baseClasses.LocationTo;

public class RouteManager {
	
	Reader read;
	
	public RouteManager(ConsoleManager reader) {
		this.read = reader;
	}

	public Route setRoute() {
		
		String name = read.readName();
		Float coordinateX = read.readCoordinateX();
		Float coordinateY = read.readCoordinateY();
		
		Integer fromLocX = read.readFromLocX();
		int fromLocY = read.readFromLocY();
		String fromName = read.readFromName();
		
		float toLocX = read.readToLocX();
		long toLocY = read.readToLocY();
		String toName = read.readToName();
		
		Integer distance = read.readDistance();
		
		return new Route(name, new Coordinates(coordinateX, coordinateY), new LocationFrom(fromLocX, fromLocY, fromName), new LocationTo(toLocX, toLocY, toName), distance);
	}
	
	/*
	public Integer readFromLocX();
    public Integer readFromLocY();
    public String readFromName();
    
    public Integer readToLocX();
    public Integer readToLocY();
    public String readToName();
    
    public Integer readDistance(); 
	 */

	
	
}
