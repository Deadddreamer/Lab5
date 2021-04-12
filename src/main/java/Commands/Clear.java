package Commands;

import Exceptions.WrongNumberOfElements;
import utility.Console;
import utility.OrganizationCollection;

public class Clear extends AbstarctCommand {
    private final OrganizationCollection organizationCollection;
    public Clear(OrganizationCollection organizationCollection){
        super("clear","очистить коллекцию");
        this.organizationCollection = organizationCollection;
    }

    @Override
    public boolean execute(String argument) {

        try {
            if (!argument.isEmpty()) throw new WrongNumberOfElements();
            organizationCollection.clearColl();
            Console.println("Коллекция удалена успешно!");
            return true;
        } catch (WrongNumberOfElements exeption) {
            Console.println("Использование: '" + getName() + "' - " + getDesc());
        }
        return false;
    }
}
