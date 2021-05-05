package Commands;

import Data.Organization;
import Exceptions.ScriptError;
import Exceptions.WrongNumberOfElements;
import utility.Console;
import utility.NewOrganization;
import utility.OrganizationCollection;

import java.time.ZonedDateTime;
/**
 * Команда InsertNullElement
 */
public class InsertNullElement extends AbstarctCommand {
    private final NewOrganization newOrganization;
    private final OrganizationCollection organizationCollection;
    public InsertNullElement(NewOrganization newOrganization, OrganizationCollection organizationCollection) {
        super("insert_null {element}","добавить новый элемент с заданным ключом");
        this.organizationCollection = organizationCollection;
        this.newOrganization = newOrganization;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongNumberOfElements();
            int key = Integer.parseInt(argument);
            organizationCollection.addOrg(key ,new Organization(
                    organizationCollection.createId(),
                    newOrganization.askName(),
                    newOrganization.askCoordinates(),
                    newOrganization.askAnnualturnOver(),
                    newOrganization.askEmployees(),
                    newOrganization.askType(),
                    newOrganization.askAdress(),
                    ZonedDateTime.now()
            ));
            Console.println("Организация успешно добавлена!");
            return true;
        } catch (WrongNumberOfElements exception) {
            Console.println("Использование: '" + getName() + "' - " + getDesc());
        }
          catch (ScriptError exception){
            return false;
          }
        return false;

    }
}
