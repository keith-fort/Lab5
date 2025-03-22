package prod.baseClasses;


public class Location {
    private Integer x; // Поле не может быть null
    private int y;
    private String name; // Поле может быть null
    private float xFloat; // Дополнительное поле
    private long yLong; // Дополнительное поле

    // Конструктор для первого варианта
    public Location(Integer x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    // Конструктор для второго варианта
    public Location(float xFloat, long yLong, String name) {
        this.xFloat = xFloat;
        this.yLong = yLong;
        this.name = name;
    }

    // Геттеры и сеттеры
    public Integer getX() { return x; }
    public int getY() { return y; }
    public String getName() { return name; }
    public float getXFloat() { return xFloat; }
    public long getYLong() { return yLong; }
    
    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }
    
}