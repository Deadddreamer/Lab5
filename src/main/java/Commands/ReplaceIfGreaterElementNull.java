package Commands;

import Data.Organization;
import Exceptions.EmptyCollectionExeption;
import Exceptions.ScriptError;
import Exceptions.WrongNumberOfElements;
import utility.Console;
import utility.NewOrganization;
import utility.OrganizationCollection;
import java.time.ZonedDateTime;
/**
 * Команда ReplaceIfGreaterElementNull
 */
public class ReplaceIfGreaterElementNull extends AbstarctCommand {
    private final OrganizationCollection organizationCollection;
    private final NewOrganization newOrganization;
    public ReplaceIfGreaterElementNull(OrganizationCollection organizationCollection, NewOrganization newOrganization) {
        super("replace_if_greater_null {element}","заменить значение по ключу, если новое значение больше старого");
        this.organizationCollection = organizationCollection;
        this.newOrganization = newOrganization;
    }

    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongNumberOfElements();
            if (organizationCollection.collSize() == 0) throw new EmptyCollectionExeption();
            Integer key = Integer.parseInt(argument);
            Organization newOrg = new Organization(
                    organizationCollection.createId(),
                    newOrganization.askName(),
                    newOrganization.askCoordinates(),
                    newOrganization.askAnnualturnOver(),
                    newOrganization.askEmployees(),
                    newOrganization.askType(),
                    newOrganization.askAdress(),
                    ZonedDateTime.now());
            if (organizationCollection.compareTwo(key, newOrg)) {
                organizationCollection.replaceOrg(key, newOrg);
            Console.println("Значение успешно перезаписано");
            }
            else{
                Console.println("Значение не перезаписано");
            }
            return true;
        }
        catch(WrongNumberOfElements exception){
            Console.println("Использование: '" + getName() + "' -" + getDesc());
        }
        catch (ScriptError exception){
            return false;
        } catch (EmptyCollectionExeption exception) {
            Console.printerror("Коллекция пуста");
        }
          catch (NullPointerException exception){
            Console.printerror("Нет такого ключа");
          }
        return false;
    }
}
