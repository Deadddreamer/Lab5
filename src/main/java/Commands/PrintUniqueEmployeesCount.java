package Commands;

import Exceptions.WrongNumberOfElements;
import utility.Console;
import utility.OrganizationCollection;
/**
 * Команда PrintUniqueEmployeesCount
 */
public class PrintUniqueEmployeesCount extends AbstarctCommand {
    private final OrganizationCollection organizationCollection;
    public PrintUniqueEmployeesCount(OrganizationCollection organizationCollection){
        super("print_unique_employees_count","вывести уникальные значения поля employeesCount всех элементов в коллекции");
        this.organizationCollection = organizationCollection;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongNumberOfElements();
            organizationCollection.printEmployees();
            return true;
        } catch (WrongNumberOfElements wrongNumberOfElements) {
            Console.println("Использование: '" + getName() + "' - " + getDesc());
        }
        catch (NullPointerException exception){
            Console.printerror("Коллекция пуста");
        }
        return false;
    }
}
