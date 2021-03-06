package Commands;
import Exceptions.WrongNumberOfElements;
import utility.Console;
/**
 * Команда Help
 */
public class Help extends AbstarctCommand {
    public Help(){
        super("help","вывести справку по доступным командам");
    }


    @Override
    public boolean execute(String argument)  {
        try {
            if (!argument.isEmpty()) throw new WrongNumberOfElements();
            return true;
        } catch (WrongNumberOfElements exception) {
            Console.println("Использование: '" + getName() + "' - " + getDesc());
        }
        return false;
    }
}
