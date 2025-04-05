package prod.commands;

import java.util.HashMap;
import prod.collection.CollectionManager;
import prod.console.ConsoleManager;

public class CommandManager {								//invoker
	
	private static HashMap<String, Command> commands = new HashMap<>();
    private ConsoleManager consoleManager;

	public CommandManager(CollectionManager collectManager, ConsoleManager consoleManager) {
		
		this.consoleManager = consoleManager;
		
		commands.put("help", new HelpCommand(collectManager));
		commands.put("info", new InfoCommand(collectManager));
        commands.put("show", new ShowCommand(collectManager));
         
        commands.put("add", new AddCommand(collectManager));
        
        commands.put("insert_at", new InsertAtIndexCommand(collectManager));
        
        commands.put("remove_at", new RemoveAtIndexCommand(collectManager));
        commands.put("update", new UpdateByIdCommand(collectManager));
        commands.put("remove_by_id", new RemoveByIdCommand(collectManager));
        commands.put("save", new SaveCommand(collectManager));
        commands.put("clear", new ClearCommand(collectManager));
        commands.put("exit", new ExitCommand(collectManager));
		/*
                       
        commands.put("execute_script", new ExecuteScriptCommand(collectManager));
        
        
        commands.put("reorder", new ReorderCommand(collectManager));
        commands.put("sum_of_distance", new SumOfDistanceCommand(collectManager));
        commands.put("filter_starts_with_name", new FilterStartsWithNameCommand(collectManager));
        commands.put("print_field_descending_distance", new PrintFieldDescendingDistanceCommand(collectManager));
        
		*/
                
	}
	
	private Command command;
	
	public void executeCommand(){
        try{
            String[] args = consoleManager.readCommand();
            if (commands.containsKey(args[0])){
                try {
                    commands.get(args[0]).execute(args);
                } catch (IllegalArgumentException e){
                    System.out.println("Ошибка. Попробуйте еще раз.");
                }
            } else {
                System.out.println("Команда не найдена.");
            }
        } catch (IllegalArgumentException e){
            System.out.println("Что-то пошло не так. Попробуйте еще раз.");
        }
    }
	
	public HashMap<String, Command> getCommands() {
		return commands;
	}
	
}
