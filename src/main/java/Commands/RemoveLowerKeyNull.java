package Commands;

import Exceptions.EmptyCollectionExeption;
import Exceptions.WrongNumberOfElements;
import utility.Console;
import utility.OrganizationCollection;
/**
 * Команда RemoveLowerKeyNull
 */
public class RemoveLowerKeyNull extends AbstarctCommand {
    private final OrganizationCollection organizationCollection;
    public RemoveLowerKeyNull(OrganizationCollection organizationCollection){
        super("remove_lower_key null","удалить из коллекции все элементы, ключ которых меньше, чем заданный");
        this.organizationCollection = organizationCollection;
    }


    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongNumberOfElements();
            if (organizationCollection.collSize() == 0) throw new EmptyCollectionExeption();
            Integer key = Integer.parseInt(argument);
            organizationCollection.removeLowerKey(key);
            Console.println("Организации удалены!");
        } catch (WrongNumberOfElements exception) {
            Console.println("Использование: '" + getName() + "' - " + getDesc());
        } catch (EmptyCollectionExeption exception) {
            Console.printerror("Коллекция пуста!");
        }


        return false;
    }
}
