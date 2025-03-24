package prod.commands;

import java.util.HashMap;
import prod.collection.CollectionManager;
import prod.console.ConsoleManager;

public class CommandManager {								//invoker
	
	private static HashMap<String, Command> commands = new HashMap<>();
    private ConsoleManager consoleManager;

	public CommandManager(CollectionManager collectManager, ConsoleManager consoleManager) {
		
		this.consoleManager = consoleManager;

        commands.put("show", new ShowCommand(collectManager));
        commands.put("help", new HelpCommand(collectManager));
        commands.put("info", new InfoCommand(collectManager));
        commands.put("clear", new ClearCommand(collectManager));
        commands.put("save", new SaveCommand(collectManager));
        commands.put("exit", new ExitCommand(collectManager));
        commands.put("add", new AddCommand(collectManager));
        
		/*
        
        commands.put("remove_by_id", new RemoveByIdCommand(collectManager));        
        commands.put("update", new UpdateIdCommand(collectManager));        
        commands.put("execute_script", new ExecuteScriptCommand(collectManager));
        commands.put("head", new HeadCommand(collectManager));
        commands.put("add_if_min", new AddIfMinCommand(collectManager));
        commands.put("remove_lower", new RemoveLowerCommand(collectManager));
        commands.put("sum_of_age", new SumOfAgeCommand(collectManager));
        commands.put("filter_contains_name", new FilterContainsNameCommand(collectManager));
        commands.put("filter_starts_with_name", new FilterStartsWithNameCommand(collectManager));
        
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
