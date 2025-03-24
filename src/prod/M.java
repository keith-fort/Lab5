package prod;

import prod.collection.CollectionManager;
import prod.commands.CommandManager;
import prod.console.ConsoleManager;
import prod.file.FileManager;

public class M {

	public static void main(String[] args) {
		
//		String link = "/Users/ivanmarkov/Desktop/Учеба/Прога/Eclipse2021-12_ws/Lab5_reserved/src/prod/text"; 
		
        CollectionManager collectionManager = new CollectionManager();			//создание менеджера коллекции
        ConsoleManager consoleManager = new ConsoleManager();					//создание менеджера консоли
        CommandManager commandManager = new CommandManager(collectionManager, consoleManager);
        FileManager fileManager = new FileManager("/Users/ivanmarkov/Desktop/Учеба/Прога/Eclipse2021-12_ws/Lab5_reserved/src/prod/text");
        
        collectionManager.setCommandManager(commandManager);
        collectionManager.setFileManager(fileManager);

     
        fileManager.loadToCollection(collectionManager.getCollection());
        
        System.out.println(collectionManager.getCollection());
        
//        fileManager.loadToCSV(collectionManager.getCollection());
        
        for (;;){
        	commandManager.executeCommand();
        }
        
	}

}

//добавить переменную окружения (и на гелиосе)
//добавить javadoc классов
//добавить mvn/gradle
//Класс, коллекцией экземпляров которого управляет программа, должен реализовывать сортировку по умолчанию.
//Подтянуть на гелиос