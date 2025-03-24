package prod.baseClasses;

import java.util.Date;

import prod.collection.IdGenerator;
import prod.utils.Time;

public class Route {

	private Long id; 							//Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; 						//Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; 			//Поле не может быть null
    private java.util.Date creationDate; 		//Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private LocationFrom from; 						//Поле не может быть null
    private LocationTo to; 						//Поле не может быть null
    private Integer distance; 					//Поле не может быть null, Значение поля должно быть больше 1
    
    private IdGenerator generator = new IdGenerator();


    //Класс, коллекцией экземпляров которого управляет программа, должен реализовывать сортировку по умолчанию.
    
    public Route(Long id, String name, Coordinates coordinates, Date creationDate, LocationFrom from, LocationTo to, Integer distance) {
//добавить проверку на допустимые значение в конструкторе
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.from = from;
        this.to = to;
        this.distance = distance;
    }
    
    public Route(String name, Coordinates coordinates, LocationFrom from, LocationTo to, Integer distance) {
    	//добавить проверку на допустимые значение в конструкторе
    	this.id = generator.generateId();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = new Date();
        this.from = from;
        this.to = to;
        this.distance = distance;
    }
    
    public Long getId() { return id; }			//Геттеры
    public String getName() { return name; }
    public Coordinates getCoordinates() { return coordinates; }
    public Date getCreationDate() { return creationDate; }
    public LocationFrom getFrom() { return from; }
    public LocationTo getTo() { return to; }
    public Integer getDistance() { return distance; }
    
    
    /**
     * Устанавливает идентификатор дракона.
     * @param id Идентификатор дракона.
     */
    public void setId(long id) {				//Сеттеры
        this.id = id;
    }

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
