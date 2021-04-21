package Commands;

import Data.Organization;
import Exceptions.WrongNumberOfElements;
import utility.Console;
import utility.NewOrganization;
import utility.OrganizationCollection;

import java.time.ZonedDateTime;

public class ReplaceIfGreaterElementNull extends AbstarctCommand {
    private final OrganizationCollection organizationCollection;
    private NewOrganization newOrganization;
    public ReplaceIfGreaterElementNull(OrganizationCollection organizationCollection, NewOrganization newOrganization) {
        super("replace_if_greater_null {element}","заменить значение по ключу, если новое значение больше старого");
        this.organizationCollection = organizationCollection;
        this.newOrganization = newOrganization;
    }

    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongNumberOfElements();
            Integer key = Integer.parseInt(argument);
            Organization newOrg = new Organization(
                    newOrganization.askId(),
                    newOrganization.askName(),
                    newOrganization.askCoordinates(),
                    newOrganization.askAnnualturnOver(),
                    newOrganization.askEmployees(),
                    newOrganization.askType(),
                    newOrganization.askAdress(),
                    ZonedDateTime.now());
            if (organizationCollection.compareTwo(key, newOrg)) {
                organizationCollection.replaceOrg(key, newOrg);
            Console.println("Значение успешно перезаписано");}
            else{
                Console.println("Значение не перезаписано");
            }

        }
        catch(WrongNumberOfElements exception){
            Console.println("Использование: '" + getName() + "' -" + getDesc());
        }
        return false;
    }
}
