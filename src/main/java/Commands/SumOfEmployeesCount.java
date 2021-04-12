package Commands;

import Exceptions.EmptyCollectionExeption;
import Exceptions.WrongNumberOfElements;
import utility.Console;
import utility.OrganizationCollection;

public class SumOfEmployeesCount extends AbstarctCommand {
private OrganizationCollection organizationCollection;
    public SumOfEmployeesCount(OrganizationCollection organizationCollection) {
        super("sum_of_employees_count", "вывести сумму значений поля employeesCount для всех элементов коллекции");
        this.organizationCollection = organizationCollection;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (organizationCollection.collSize() != 0) {
                Long sum_of_employess = organizationCollection.sumEmployees();
                Console.println("Сумма всех работников: " + sum_of_employess);
                return true;}
            else {Console.printerror("Коллекция пуста");}
                if (!argument.isEmpty()) throw new WrongNumberOfElements();

            } catch(WrongNumberOfElements exception){
                Console.println("Использование: '" + getName() + "' -" + getDesc());
            }


        return false;
    }
}