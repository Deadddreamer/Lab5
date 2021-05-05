package Main;

import Commands.*;
import utility.*;
import utility.Console;
import java.util.*;

/**
 * Main класс, запускает программу
 */
public class Main {
    public static final String Type1 = "$ ";
    public static final String Type2 = "> ";

    public static void main(String[] args) {
        try (Scanner userScanner = new Scanner(System.in)) {
           OrganizationCollection organizationCollection = new OrganizationCollection();
           organizationCollection.loadColl();
            NewOrganization newOrganization = new NewOrganization(userScanner);
            CommandsList commandsList = new CommandsList(new Clear(organizationCollection), new CountLessThanEmployeesCount(organizationCollection), new ExecuteScriptFileName(),
                    new Exit(), new Help(), new Info(organizationCollection), new InsertNullElement(newOrganization,organizationCollection), new PrintUniqueEmployeesCount(organizationCollection), new RemoveKeyNull(organizationCollection),
                    new RemoveLowerElement(organizationCollection, newOrganization), new RemoveLowerKeyNull(organizationCollection), new ReplaceIfGreaterElementNull(organizationCollection, newOrganization), new Save(organizationCollection), new Show(organizationCollection),
                    new SumOfEmployeesCount(organizationCollection), new UpdateIdElement(organizationCollection, newOrganization));

            Console console = new Console(userScanner, commandsList, newOrganization);
            console.consolemode();
        }


    }
    }
