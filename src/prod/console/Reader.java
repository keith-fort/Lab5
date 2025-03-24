package prod.console;

public interface Reader {

	public String readName();
	
	public float readCoordinateX();
    public float readCoordinateY();
    
    public Integer readFromLocX();
    public int readFromLocY();
    public String readFromName();
    
    public float readToLocX();
    public long readToLocY();
    public String readToName();
    
    public Integer readDistance(); 
	
}
