package prod.baseClasses;

public class LocationTo {

	private float x;
    private long y;
    private String name; //Строка не может быть пустой, Поле не может быть null

    /*
    public LocationTo(String x3, String y3, String name2) {
    	this.x = Float.parseFloat(x3);
    	this.y = Long.parseLong(y3);
    	this.name = name2;
    }
    */
    
    public LocationTo(float x, long y, String name) {
    	this.x = x;
    	this.y = y;
    	this.name = name;
    }
    
    public float getX() {
    	return x;
    }
    
    public long getY() {
    	return y;
    }
    
    public String getName() {
    	return name;
    }
    
    @Override
    public String toString() {
        return "LocationTo{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }
}
