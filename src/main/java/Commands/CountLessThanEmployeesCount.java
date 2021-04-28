package Commands;

import Data.Organization;
import Exceptions.WrongNumberOfElements;
import utility.Console;
import utility.OrganizationCollection;

public class CountLessThanEmployeesCount extends AbstarctCommand {
    private OrganizationCollection organizationCollection;
    public CountLessThanEmployeesCount(OrganizationCollection organizationCollection){
        super("count_less_than_employees_count","вывести количество элементов, значение поля employeesCount которых меньше заданного");
        this.organizationCollection = organizationCollection;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongNumberOfElements();
            Long less = Long.parseLong(argument);
            organizationCollection.lessThanEmployees(less);
            return true;
        } catch (WrongNumberOfElements wrongNumberOfElements) {
            Console.println("Использование: '" + getName() + "' - " + getDesc());
        }
        catch (NullPointerException exception){
            Console.printerror("Ошибка");
        }
        return false;
    }
}
