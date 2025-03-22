package prod.baseClasses;

public class Coordinates {

	private float x;
    private float y; //Максимальное значение поля: 618
	
/*    public Coordinates(String x0, String y0) {
    	this.x = Float.parseFloat(x0);
    	this.y = Float.parseFloat(y0);
    }
*/
    public Coordinates(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() { return x; }
    public float getY() { return y; }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
