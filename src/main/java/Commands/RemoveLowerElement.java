package Commands;

import Data.Organization;
import Exceptions.EmptyCollectionExeption;
import Exceptions.NoSuchOrganization;
import Exceptions.WrongNumberOfElements;
import utility.Console;
import utility.NewOrganization;
import utility.OrganizationCollection;

import java.time.ZonedDateTime;

public class RemoveLowerElement extends AbstarctCommand {
    private OrganizationCollection organizationCollection;
    private NewOrganization newOrganization;
    public RemoveLowerElement(OrganizationCollection organizationCollection, NewOrganization newOrganization){
        super("remove_lower {element}","удалить из коллекции все элементы, меньшие, чем заданный");
        this.newOrganization = newOrganization;
        this.organizationCollection = organizationCollection;
    }
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongNumberOfElements();
            if (organizationCollection.collSize() == 0) throw new EmptyCollectionExeption();
            Organization findOrg = new Organization(
                    newOrganization.askId(),
                    newOrganization.askName(),
                    newOrganization.askCoordinates(),
                    newOrganization.askAnnualturnOver(),
                    newOrganization.askEmployees(),
                    newOrganization.askType(),
                    newOrganization.askAdress(),
                    ZonedDateTime.now()

            );
            Organization orgFound = organizationCollection.findByInsert(findOrg);
            if (orgFound == null) throw new NoSuchOrganization();
            organizationCollection.removeLower(orgFound);
            Console.println("Организации удалены!");
            return true;
        } catch (WrongNumberOfElements exception) {
            Console.println("Использование: '" + getName() + "' - " +getDesc());
        } catch (EmptyCollectionExeption exception) {
            Console.printerror("Коллекция пуста!");
        } catch (NoSuchOrganization exception) {
            Console.printerror("Организации с такими данными в коллекции нет!");
        }
        return false;
    }
}
