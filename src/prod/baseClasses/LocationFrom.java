package prod.baseClasses;

public class LocationFrom {

	private Integer x; //Поле не может быть null
    private int y;
    private String name; //Поле может быть null
	
    public LocationFrom(String x2, String y2, String name1) {
    	this.x = Integer.parseInt(x2);
    	this.y = Integer.parseInt(y2);
    	this.name = name1;
    }
    
}

