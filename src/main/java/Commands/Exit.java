package Commands;

import Exceptions.WrongNumberOfElements;
import utility.Console;

public class Exit extends AbstarctCommand {
    public Exit() {
        super("exit", "завершить программу");
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongNumberOfElements();
            return true;
        } catch (WrongNumberOfElements exception) {
            Console.println("Использование: '" + getName() + "' - " + getDesc());
        }
        return false;
    }
}