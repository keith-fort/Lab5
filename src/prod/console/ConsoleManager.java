package prod.console;

public class ConsoleManager {
	
	ReadController rc = new ReadController();
	
	public String[] readCommand(){
        rc.printLine("Введите команду: \n");
        String command = rc.readLine();
        String[] args = command.split(" ");
        return args;
    }
	
	public void printLine(Object str) {
		
		System.out.println(str);
		
	}
	
}
