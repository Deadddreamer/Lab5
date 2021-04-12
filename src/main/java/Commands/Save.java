package Commands;

import Exceptions.WrongNumberOfElements;
import utility.Console;
import utility.OrganizationCollection;

public class Save extends AbstarctCommand {
    private OrganizationCollection organizationCollection;
    public Save(OrganizationCollection organizationCollection){
        super("save", "сохранить коллекцию в файл");
        this.organizationCollection = organizationCollection;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongNumberOfElements();
            organizationCollection.saveColl();
            Console.println("Коллекция сохранена!");
            return true;
        } catch (WrongNumberOfElements exception) {
            Console.println("Использование: '" + getName() + "' - " + getDesc());
        }
        return false;
    }
}
