package Commands;

import Exceptions.EmptyCollectionExeption;
import Exceptions.WrongNumberOfElements;
import utility.Console;
import utility.OrganizationCollection;

public class Show extends AbstarctCommand{
    private final OrganizationCollection organizationCollection;
    public Show(OrganizationCollection organizationCollection) {
        super("show","вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.organizationCollection = organizationCollection;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongNumberOfElements();
            organizationCollection.outcall();
            if (organizationCollection.collSize() == 0) throw new EmptyCollectionExeption();
            return true;
        } catch (WrongNumberOfElements exception) {
            Console.println("Использование: '" + getName() + "' - " + getDesc());
        } catch (EmptyCollectionExeption exeption) {
            Console.printerror("Коллекция пуста!");
        }
        return false;
    }
}
