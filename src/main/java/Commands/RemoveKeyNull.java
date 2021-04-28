package Commands;

import Data.Organization;
import Exceptions.EmptyCollectionExeption;
import Exceptions.KeyNotFoundExeption;
import Exceptions.WrongNumberOfElements;
import utility.Console;
import utility.OrganizationCollection;

public class RemoveKeyNull extends AbstarctCommand {
    private OrganizationCollection organizationCollection;
    public RemoveKeyNull(OrganizationCollection organizationCollection) {
        super("remove_key_null","удалить элемент из коллекции по его ключу");
        this.organizationCollection = organizationCollection;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongNumberOfElements();
            if (organizationCollection.collSize() == 0) throw new EmptyCollectionExeption();
            int id = Integer.parseInt(argument);
            if (!organizationCollection.trykey(id)) throw new KeyNotFoundExeption();
            organizationCollection.removeOrg(id);
            Console.println("Организация удалена!");
            return true;
        } catch (WrongNumberOfElements exception) {
            Console.println("Использование: '" + getName() + "' - " + getDesc());
        } catch (EmptyCollectionExeption exception) {
            Console.printerror("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            Console.printerror("Ключ должен быть представлен числом!");
        } catch (KeyNotFoundExeption exception) {
            Console.printerror("Организации с таким ключом нет!");
        }
        return false;
    }
}
