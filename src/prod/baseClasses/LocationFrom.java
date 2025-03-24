package prod.baseClasses;

public class LocationFrom {

	private Integer x; //Поле не может быть null
    private int y;
    private String name; //Поле может быть null

    /*
    public LocationFrom(String x2, String y2, String name1) {
    	this.x = Integer.parseInt(x2);
    	this.y = Integer.parseInt(y2);
    	this.name = name1;
    }
    */
    
    public LocationFrom(Integer x, int y, String name) {
    	this.x = x;
    	this.y = y;
    	this.name = name;
    }
 
    public Integer getX() {
    	return x;
    }
    
    public int getY() {
    	return y;
    }
    
    public String getName() {
    	return name;
    }
    
    @Override
    public String toString() {
        return "LocationFrom{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }
    
}

