package Commands;

import utility.NewOrganization;
import utility.OrganizationCollection;

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
        return false;
    }
}
