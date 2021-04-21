package utility;
import Main.Main;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Console {
    private Scanner scanner;
    private CommandsList commandsList;
    public Console(Scanner scanner, CommandsList commandsList) {
    this.scanner = scanner;
    this.commandsList = commandsList;
    }

    public void consolemode() {
        String[] userCommand = {"", ""};
        int commandStatus;
        try {
            do {
                Console.print(Main.PS1);
                userCommand = (scanner.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                commandStatus = launchCommand(userCommand);
            } while (commandStatus != 2);
        } catch (NoSuchElementException exception) {
            Console.printerror("Пользовательский ввод не обнаружен!");
        } catch (IllegalStateException exception) {
            Console.printerror("Непредвиденная ошибка!");
        }

    }
    public static void print(Object toOut) {
        System.out.print(toOut);
    }

    public static void printtable(Object element1, Object element2) {
        System.out.printf("%-37s%-1s%n", element1, element2);
    }

    public static void println(Object toOut) {
        System.out.println(toOut);


    }
    public static void printerror(Object toOut) {
        System.out.println("error: " + toOut);
    }


    private int launchCommand(String[] userCommand) {
        switch (userCommand[0]) {
            case "":
                break;
            case "help":
                if (!commandsList.help(userCommand[1])) return 1;
                break;
            case "show":
                if(!commandsList.show(userCommand[1])) return 1;
                break;
            case "exit":
                if (!commandsList.exit(userCommand[1])) return 1;
                else return 2;
            case "remove_key_null":
                if(!commandsList.removeKeyNull(userCommand[1])) return 1;
                break;
            case "clear":
                if (!commandsList.clear(userCommand[1])) return 1;
                break;
            case "remove_lower_key_null":
                if (!commandsList.removeLowerKeyNull(userCommand[1])) return 1;
                break;
            case "save":
                if(!commandsList.save(userCommand[1])) return 1;
                break;
            case "insert_null":
                if (!commandsList.insertNullElement(userCommand[1])) return 1;
                break;
            case "info":
                if (!commandsList.info(userCommand[1])) return 1;
                break;
            case "sum_of_employees_count":
                if (!commandsList.sumOfEmployees(userCommand[1])) return 1;
                break;
            case "count_less_than_employees_count":
                if (!commandsList.lessThanEmployees(userCommand[1])) return 1;
                break;
            case "print_unique_employees_count":
                if (!commandsList.printUniqueEmployees(userCommand[1])) return 1;
                break;
            case "update_id":
                if (!commandsList.updateId(userCommand[1])) return 1;
                break;
            case "remove_lower":
                if (!commandsList.removeLowerElement(userCommand[1])) return 1;
                break;
            case "replace_if_greater_null":
                if(!commandsList.replaceIfGreater(userCommand[1])) return 1;
                break;
            default:
                if (!commandsList.noSuchCommand(userCommand[0])) return 1;
        }
        return 0;
    }
}