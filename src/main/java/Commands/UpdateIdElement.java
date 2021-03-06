package Commands;

import Data.Organization;
import Exceptions.ScriptError;
import Exceptions.WrongNumberOfElements;
import utility.Console;
import utility.NewOrganization;
import utility.OrganizationCollection;

import java.time.ZonedDateTime;

/**
 * Команда UpdateIdElement
 */
public class UpdateIdElement extends AbstarctCommand {
    private final OrganizationCollection organizationCollection;
    private final NewOrganization newOrganization;
    public UpdateIdElement(OrganizationCollection organizationCollection, NewOrganization newOrganization){
        super("update_id {element}","обновить значение элемента коллекции, id которого равен заданному");
        this.newOrganization = newOrganization;
        this.organizationCollection = organizationCollection;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongNumberOfElements();
            int key = Integer.parseInt(argument);
            organizationCollection.addOrg(organizationCollection.findId(key) ,new Organization(key,
                    newOrganization.askName(),
                    newOrganization.askCoordinates(),
                    newOrganization.askAnnualturnOver(),
                    newOrganization.askEmployees(),
                    newOrganization.askType(),
                    newOrganization.askAdress(),
                    ZonedDateTime.now()
            ));
            Console.println("Организация успешно обновлена!");
            return true;
        } catch (WrongNumberOfElements exception) {
            Console.println("Использование: '" + getName() + "' - " + getDesc());
        }
          catch (ScriptError exception){
            return false;
        }
          catch (NullPointerException exception){
            Console.printerror("Нет такого id");
          }
        return false;
    }
}
