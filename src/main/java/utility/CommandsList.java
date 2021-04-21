package utility;

import Commands.CommandInterface;


import java.util.ArrayList;
import java.util.List;


public class CommandsList {
    private List<CommandInterface> commands = new ArrayList<>();
    private CommandInterface clear;
    private CommandInterface countLessEmployeesCount;
    private CommandInterface executeScriptFileName;
    private CommandInterface exit;
    private CommandInterface help;
    private CommandInterface info;
    private CommandInterface insertNullElement;
    private CommandInterface printUniqueEmployeesCount;
    private CommandInterface removeKeyNull;
    private CommandInterface removeLowerElement;
    private CommandInterface removeLowerKeyNull;
    private CommandInterface replaceIfGreaterElementNull;
    private CommandInterface save;
    private CommandInterface show;
    private CommandInterface sumOfEmployeesCount;
    private CommandInterface updateIdElement;

    public CommandsList(CommandInterface clear, CommandInterface countLessEmployeesCount, CommandInterface executeScriptFileName,
                        CommandInterface exit, CommandInterface help, CommandInterface info, CommandInterface insertNullElement,
                        CommandInterface printUniqueEmployeesCount, CommandInterface removeKeyNull, CommandInterface removeLowerElement,
                        CommandInterface removeLowerKeyNull, CommandInterface replaceIfGreaterElementNull, CommandInterface save,
                        CommandInterface show, CommandInterface sumOfEmployeesCount, CommandInterface updateIdElement) {
        this.help = help;
        this.clear = clear;
        this.countLessEmployeesCount = countLessEmployeesCount;
        this.executeScriptFileName = executeScriptFileName;
        this.exit = exit;
        this.info = info;
        this.insertNullElement = insertNullElement;
        this.printUniqueEmployeesCount = printUniqueEmployeesCount;
        this.removeKeyNull = removeKeyNull;
        this.removeLowerElement = removeLowerElement;
        this.removeLowerKeyNull = removeLowerKeyNull;
        this.replaceIfGreaterElementNull = replaceIfGreaterElementNull;
        this.save = save;
        this.show = show;
        this.sumOfEmployeesCount = sumOfEmployeesCount;
        this.updateIdElement = updateIdElement;
        commands.add(clear);
        commands.add(countLessEmployeesCount);
        commands.add(executeScriptFileName);
        commands.add(exit);
        commands.add(help);
        commands.add(info);
        commands.add(insertNullElement);
        commands.add(printUniqueEmployeesCount);
        commands.add(removeKeyNull);
        commands.add(removeLowerElement);
        commands.add(removeLowerKeyNull);
        commands.add(replaceIfGreaterElementNull);
        commands.add(save);
        commands.add(show);
        commands.add(sumOfEmployeesCount);
        commands.add(updateIdElement);
    }

    public boolean help(String argument) {
        if (help.execute(argument)) {
            for (CommandInterface command : commands) {
                Console.printtable(command.getName(), command.getDesc());
            }
            return true;
        } else return false;
    }
    public boolean exit(String argument){
       return exit.execute(argument);
    }

    public boolean noSuchCommand(String command) {
        Console.println("Команда '" + command + "' не найдена. Наберите 'help' для справки.");
        return false;
    }
    public boolean show (String argument){
       return show.execute(argument);

    }
    public boolean removeKeyNull(String argument){
        return removeKeyNull.execute(argument);
    }
    public boolean clear(String argument){
        return clear.execute(argument);
    }
    public boolean removeLowerKeyNull(String argument){
        return removeLowerKeyNull.execute(argument);
    }
    public boolean save(String argument){
        return save.execute(argument);
    }
    public boolean insertNullElement(String argument){return insertNullElement.execute(argument);}
    public boolean info(String argument){return info.execute(argument);}
    public boolean sumOfEmployees(String argument){return sumOfEmployeesCount.execute(argument);}
    public boolean lessThanEmployees(String argument){return countLessEmployeesCount.execute(argument);}
    public boolean printUniqueEmployees(String argument){return printUniqueEmployeesCount.execute(argument);}
    public boolean updateId(String argument){return updateIdElement.execute(argument);}
    public boolean removeLowerElement(String argument){return removeLowerElement.execute(argument);}
    public boolean replaceIfGreater(String argument){return replaceIfGreaterElementNull.execute(argument);}
}