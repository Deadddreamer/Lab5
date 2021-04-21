package Main;

import Commands.*;
import Data.Address;
import Data.Coordinates;
import Data.Organization;
import Data.OrganizationType;
import com.thoughtworks.xstream.XStream;
import utility.*;
import utility.Console;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.*;

public class Main {
    public static final String PS1 = "$ ";
    public static final String PS2 = "> ";

    public static void main(String[] args) {
        try (Scanner userScanner = new Scanner(System.in)) {
           OrganizationCollection organizationCollection = new OrganizationCollection();
            NewOrganization newOrganization = new NewOrganization(userScanner);
            CommandsList commandsList = new CommandsList(new Clear(organizationCollection), new CountLessThanEmployeesCount(organizationCollection), new ExecuteScriptFileName(),
                    new Exit(), new Help(), new Info(organizationCollection), new InsertNullElement(newOrganization,organizationCollection), new PrintUniqueEmployeesCount(organizationCollection), new RemoveKeyNull(organizationCollection),
                    new RemoveLowerElement(organizationCollection, newOrganization), new RemoveLowerKeyNull(organizationCollection), new ReplaceIfGreaterElementNull(organizationCollection, newOrganization), new Save(organizationCollection), new Show(organizationCollection),
                    new SumOfEmployeesCount(organizationCollection), new UpdateIdElement(organizationCollection, newOrganization));

            Console console = new Console(userScanner, commandsList);
            console.consolemode();
        }


    }
    }
