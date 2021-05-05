package Commands;

import Exceptions.WrongNumberOfElements;
import utility.Console;
/**
 * Команда ExecuteScriptFileName
 */
public class ExecuteScriptFileName extends AbstarctCommand {
    public ExecuteScriptFileName() {
        super("execute_script {file name}", "считать и исполнить скрипт из указанного файла");
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongNumberOfElements();
            Console.println("Выполнение скрипта '" + argument + "'...");
            return true;
        } catch (WrongNumberOfElements exception) {
            Console.println("Использование: '" + getName() + "' - " + getDesc());
        }
        return false;
    }
}
