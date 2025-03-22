package prod.baseClasses;

import java.util.Date;

import prod.utils.Time;

public class Route {

	private Long id; 							//Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; 						//Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; 			//Поле не может быть null
    private java.util.Date creationDate; 		//Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; 					//Поле не может быть null
    private Location to; 						//Поле не может быть null
    private Integer distance; 					//Поле не может быть null, Значение поля должно быть больше 1
	
/*   public Route(String id, String name, String x1, String y1, String creationDate, String x2, String y2, String name1, String x3, String y3, String name2, String distance) {		//name1 - может быть пустой
    	this.id = Long.valueOf(id);
    	this.name = name;
    	this.coordinates = new Coordinates(x1, y1); 
    	this.creationDate = new Date();
    	this.from = new LocationFrom(x2, y2, name1);
    	this.to = new LocationTo(x3, y3, name2);
    	this.distance = Integer.valueOf(distance);
    } */

    public Route(Long id, String name, Coordinates coordinates, Date creationDate, Location from, Location to, Integer distance) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.from = from;
        this.to = to;
        this.distance = distance;
    }
    
    public Long getId() { return id; }			//Геттеры
    public String getName() { return name; }
    public Coordinates getCoordinates() { return coordinates; }
    public Date getCreationDate() { return creationDate; }
    public Location getFrom() { return from; }
    public Location getTo() { return to; }
    public Integer getDistance() { return distance; }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", from=" + from +
                ", to=" + to +
                ", distance=" + distance +
                '}';
    }
    
    
 // toString2 для записи в CSV
    
    public String toString2() {
        return id + "," + name + "," + coordinates.getX() + "," + coordinates.getY() + "," +
                creationDate.getTime() + "," + from.getX() + "," + from.getY() + "," + from.getName() + "," +
                to.getX() + "," + to.getY() + "," + to.getName() + "," + distance;
    }
}
