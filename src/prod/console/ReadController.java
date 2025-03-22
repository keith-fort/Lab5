package prod.console;

import java.util.Scanner;

public class ReadController {

	
	
	public String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().replace(',', '.').trim();
    }
	
	public void printLine(Object str){
        System.out.print(str);
    }
	
}
