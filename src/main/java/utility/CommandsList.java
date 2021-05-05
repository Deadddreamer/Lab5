package utility;

import Commands.CommandInterface;


import java.util.ArrayList;
import java.util.List;

/**
 * Класс управляющий командами
 */
public class CommandsList {
    private List<CommandInterface> commands = new ArrayList<>();
    private final CommandInterface clear;
    private final CommandInterface countLessEmployeesCount;
    private final CommandInterface executeScriptFileName;
    private final CommandInterface exit;
    private final CommandInterface help;
    private final CommandInterface info;
    private final CommandInterface insertNullElement;
    private final CommandInterface printUniqueEmployeesCount;
    private final CommandInterface removeKeyNull;
    private final CommandInterface removeLowerElement;
    private final CommandInterface removeLowerKeyNull;
    private final CommandInterface replaceIfGreaterElementNull;
    private final CommandInterface save;
    private final CommandInterface show;
    private final CommandInterface sumOfEmployeesCount;
    private final CommandInterface updateIdElement;

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
        commands.add(help);
    }

    /**
     * Выводит все команды и их описание
     * @param argument аргумент команды
     * @return статус завершения команды
     */
    public boolean help(String argument) {
        if (help.execute(argument)) {
            for (CommandInterface command : commands) {
                Console.printtable(command.getName(), command.getDesc());
            }
            return true;
        } else return false;
    }
    /**
     * Вызывает команду exit
     * @param argument аргумент команды
     * @return статус завершения команды
     */
    public boolean exit(String argument){
       return exit.execute(argument);
    }
    /**
     * Сообщает, что нет введёной команды
     * @return статус завершения команды
     */
    public boolean noSuchCommand(String command) {
        Console.println("Команда '" + command + "' не найдена. Наберите 'help' для справки.");
        return false;
    }
    /**
     * Вызывает команду show
     * @param argument аргумент команды
     * @return статус завершения команды
     */
    public boolean show (String argument){
        return show.execute(argument);
    }
    /**
     * Вызывает команду removeKeyNull
     * @param argument аргумент команды
     * @return статус завершения команды
     */
    public boolean removeKeyNull(String argument){
        return removeKeyNull.execute(argument);
    }
    /**
     * Вызывает команду clear
     * @param argument аргумент команды
     * @return статус завершения команды
     */
    public boolean clear(String argument){
        return clear.execute(argument);
    }
    /**
     * Вызывает команду removeLowerKeyNull
     * @param argument аргумент команды
     * @return статус завершения команды
     */
    public boolean removeLowerKeyNull(String argument){
        return removeLowerKeyNull.execute(argument);
    }
    /**
     * Вызывает команду save
     * @param argument аргумент команды
     * @return статус завершения команды
     */
    public boolean save(String argument){
        return save.execute(argument);
    }
    /**
     * Вызывает команду insertNullElement
     * @param argument аргумент команды
     * @return статус завершения команды
     */
    public boolean insertNullElement(String argument){
        return insertNullElement.execute(argument);
    }
    /**
     * Вызывает команду info
     * @param argument аргумент команды
     * @return статус завершения команды
     */
    public boolean info(String argument){
        return info.execute(argument);
    }
    /**
     * Вызывает команду sumOfEmployees
     * @param argument аргумент команды
     * @return статус завершения команды
     */
    public boolean sumOfEmployees(String argument){
        return sumOfEmployeesCount.execute(argument);
    }
    /**
     * Вызывает команду lessThanEmployees
     * @param argument аргумент команды
     * @return статус завершения команды
     */
    public boolean lessThanEmployees(String argument){
        return countLessEmployeesCount.execute(argument);
    }
    /**
     * Вызывает команду printUniqueEmployees
     * @param argument аргумент команды
     * @return статус завершения команды
     */
    public boolean printUniqueEmployees(String argument){
        return printUniqueEmployeesCount.execute(argument);
    }
    /**
     * Вызывает команду updateId
     * @param argument аргумент команды
     * @return статус завершения команды
     */
    public boolean updateId(String argument){
        return updateIdElement.execute(argument);
    }
    /**
     * Вызывает команду removeLowerElement
     * @param argument аргумент команды
     * @return статус завершения команды
     */
    public boolean removeLowerElement(String argument){
        return removeLowerElement.execute(argument);
    }
    /**
     * Вызывает команду replaceIfGreater
     * @param argument аргумент команды
     * @return статус завершения команды
     */
    public boolean replaceIfGreater(String argument){
        return replaceIfGreaterElementNull.execute(argument);
    }
    /**
     * Вызывает команду executeScript
     * @param argument аргумент команды
     * @return статус завершения команды
     */
    public boolean executeScript(String argument){
        return executeScriptFileName.execute(argument);
    }
}