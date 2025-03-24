package prod.console;

/**
 * Класс ConsoleManager управляет вводом и выводом данных через консоль.
 * Используется для чтения различных типов данных, таких как строки, числа и т.д.
 */

public class ConsoleManager implements Reader{
	
	ReadController rc = new ReadController();
	
	public String[] readCommand(){
        rc.printLine("Введите команду: \n");
        String command = rc.readLine();
        String[] args = command.split(" ");
        return args;
    }
	
	
	public String readName() {
		rc.printLine("Введите название маршрута: ");
        String name;
        for (;;){
            name = rc.readLine();
            System.out.println();
            if (name.isEmpty() || name.isBlank()){
                rc.printLine("Строка не может быть пустой! Введите название маршрута: ");
            } else {
                return name;
            }
        }
	}
	
	public float readCoordinateX() {
		rc.printLine("Введите координату X: ");
        Float coordinateX;

        for (;;) {
            try {
                coordinateX = rc.readFloat();
                if (coordinateX == null) {
                    rc.printLine("Строка не может быть пустой. Введите координату X: ");
                }else{
                    return coordinateX;
                }
            } catch (NumberFormatException e) {
                rc.printLine("Число введено неверно. Введите координату X: ");
            }
        }
	}
	
	public float readCoordinateY() {
		rc.printLine("Введите координату Y: ");
        Float coordinateY;
        for (;;){
            try {
                coordinateY = rc.readFloat();
                if (coordinateY == null) {
                    rc.printLine("Строка не может быть пустой. Введите координату Y: ");
                if (coordinateY > 618) {
                	rc.printLine("Строка не может быть пустой. Введите координату Y: ");
                }
                } else {
                    return coordinateY;
                }
            } catch (NumberFormatException e) {
                rc.printLine("Число введено неверно. Введите координату Y: ");
            }
        }
	}
	
	
	
	public Integer readFromLocX() {
		rc.printLine("Введите координату X начала: ");
        Integer coordinateX;

        for (;;) {
            try {
                coordinateX = rc.readInteger();
                if (coordinateX == null) {
                    rc.printLine("Строка не может быть пустой. Введите координату X: ");
                }else{
                    return coordinateX;
                }
            } catch (NumberFormatException e) {
                rc.printLine("Число введено неверно. Введите координату X: ");
            }
        }
	}
	
	
	public int readFromLocY() {
		rc.printLine("Введите координату Y начала: ");
        Integer coordinateY;

        for (;;) {
            try {
                coordinateY = rc.readInteger();
                if (coordinateY == null) {
                    rc.printLine("Строка не может быть пустой. Введите координату Y: ");
                }else{
                    return coordinateY;
                }
            } catch (NumberFormatException e) {
                rc.printLine("Число введено неверно. Введите координату Y: ");
            }
        }
	}
	
	
	public String readFromName() {
		rc.printLine("Введите название локации начала: ");
        String name;
        for (;;){
            name = rc.readLine();
            System.out.println();
            return name;
        }
	}

	
	public float readToLocX() {
		rc.printLine("Введите координату X конца: ");
        Float coordinateX;

        for (;;) {
            try {
                coordinateX = rc.readFloat();
                if (coordinateX == null) {
                    rc.printLine("Строка не может быть пустой. Введите координату X конца: ");
                }else{
                    return coordinateX;
                }
            } catch (NumberFormatException e) {
                rc.printLine("Число введено неверно. Введите координату X конца: ");
            }
        }
	}
		
	public long readToLocY() {
		rc.printLine("Введите координату Y конца: ");
        Long coordinateY;

        for (;;) {
            try {
                coordinateY = rc.readLong();
                if (coordinateY == null) {
                    rc.printLine("Строка не может быть пустой. Введите координату Y конца: ");
                }else{
                    return coordinateY;
                }
            } catch (NumberFormatException e) {
                rc.printLine("Число введено неверно. Введите координату Y конца: ");
            }
        }
	}
	
	public String readToName() {
		rc.printLine("Введите название локации конца: ");
        String name;
        for (;;){
            name = rc.readLine();
            System.out.println();
            if (name.isEmpty() || name.isBlank()){
                rc.printLine("Строка не может быть пустой! Введите название локации конца: ");
            } else {
                return name;
            }
        }
	}

	
	public Integer readDistance() {
		rc.printLine("Введите протяженность маршрута: ");
        Integer distance;

        for (;;) {
            try {
            	distance = rc.readInteger();
                if (distance == null) {
                    rc.printLine("Строка не может быть пустой. Введите протяженность маршрута: ");
                }else{
                    return distance;
                }
            } catch (NumberFormatException e) {
                rc.printLine("Число введено неверно. Введите протяженность маршрута: ");
            }
        }
	}
	
	/*
	+public String readName();
	
	+public float readCoordinateX();
    +public float readCoordinateY();
    
    +public Integer readFromLocX();
    +public int readFromLocY();
    +public String readFromName();
    
    +public float readToLocX();
    +public long readToLocY();
    +public String readToName();
    
    public Integer readDistance(); 
	 */
	
	
	
	
	
	
	
	
	
	
	public void printLine(Object str) {		
		System.out.println(str);		
	}
	
}
