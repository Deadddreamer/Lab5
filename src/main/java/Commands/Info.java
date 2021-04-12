package Commands;

import Exceptions.WrongNumberOfElements;
import utility.Console;
import utility.OrganizationCollection;

public class Info extends AbstarctCommand {
private OrganizationCollection organizationCollection;
    public Info(OrganizationCollection organizationCollection) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции");
        this.organizationCollection = organizationCollection;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongNumberOfElements();
            Console.println("Сведения о коллекции:");
            Console.println(" Тип: " + organizationCollection.collTypy());
            Console.println(" Количество элементов: " + organizationCollection.collSize());
            Console.println(" Дата последней инициализации: " + organizationCollection.getInitTime());
            if(organizationCollection.getLastSave() == null) {
                Console.println(" Сохранение ещё не происходило");
            }
            else {Console.println(" Дата последнего сохранения: " + organizationCollection.getLastSave());}
            return true;
        } catch (WrongNumberOfElements exception) {
            Console.println("Использование: '" + getName() + "' - " + getDesc());
            return false;
        }
    }
}