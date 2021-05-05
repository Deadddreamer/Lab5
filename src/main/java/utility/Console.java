package utility;
import Exceptions.RecursionNotWelcome;
import Main.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс для чтения команд с пользовательского ввода
 */
public class Console {
    private final Scanner scanner;
    private final CommandsList commandsList;
    private final NewOrganization newOrganization;
    private List<String> script = new ArrayList<>();
    public Console(Scanner scanner, CommandsList commandsList, NewOrganization newOrganization) {
    this.scanner = scanner;
    this.commandsList = commandsList;
    this.newOrganization = newOrganization;
    }
    /**
     * Режим пользовательского ввода
     */
    public void consolemode() {
        String[] userCommand = {"", ""};
        int commandStatus;
        try {
            do {
                Console.print(Main.Type1);
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

    /**
     * Режим скрипта
     * @param argument аргумент
     * @return статус завершения
     */

    public int scriptMode(String argument) {
        String[] userCommand = {"", ""};
        int commandStatus;
        try {
            Path p = Paths.get(argument);
            if (p.toRealPath().toString().length() > 3 && p.toRealPath().toString().trim().startsWith("/dev")) return 1;

        } catch (InvalidPathException | IOException exception) {
            Console.printerror("Зачем!!!!???");
        }
        script.add(argument);
        try (Scanner scriptScanner = new Scanner(new File(argument))) {
            if (!scriptScanner.hasNext()) throw new NoSuchElementException();
            Scanner tmpScanner = newOrganization.getScanner();
            newOrganization.userScanner(scriptScanner);
            newOrganization.setScriptMode();
            do {
                userCommand = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                while (scriptScanner.hasNextLine() && userCommand[0].isEmpty()) {
                    userCommand = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                    userCommand[1] = userCommand[1].trim();
                }
                Console.println(Main.Type1 + String.join(" ", userCommand));
                if (userCommand[0].equals("execute_script")) {
                    for (String script : script) {
                        if (userCommand[1].equals(script)) throw new RecursionNotWelcome();
                    }
                }
                commandStatus = launchCommand(userCommand);
            } while (commandStatus == 0 && scriptScanner.hasNextLine());
            newOrganization.userScanner(tmpScanner);
            newOrganization.setInteractiveMod();
            if (commandStatus == 1 && !(userCommand[0].equals("execute_script") && !userCommand[1].isEmpty()))
                Console.println("Проверьте скрипт на корректность введенных данных!");
            return commandStatus;
        }
          catch (FileNotFoundException exception) {
            Console.printerror("Файл со скриптом не найден!");
        } catch (NoSuchElementException exception) {
            Console.printerror("Файл со скриптом пуст!");
        } catch (RecursionNotWelcome exception) {
            Console.printerror("Скрипты не могут вызываться рекурсивно!");
        } catch (IllegalStateException exception) {
            Console.printerror("Непредвиденная ошибка!");
            System.exit(0);

        } finally {
            script.remove(script.size()-1);
        }
        return 1;
    }

    /**
     * Выводит на экран агрумент
     * @param toOut выводимый аргумент
     */
    public static void print(Object toOut) {
        System.out.print(toOut);
    }

    /**
     * Выводит на экран форматированные аргументы
     * @param element1 аргумент 1
     * @param element2 аргумент 2
     */
    public static void printtable(Object element1, Object element2) {
        System.out.printf("%-40s%-4s%n", element1, element2);
    }

    /**
     * Выводит на экран аргумент в новую строку
     * @param toOut аргумент
     */
    public static void println(Object toOut) {
        System.out.println(toOut);

    }

    /**
     * Выводит на экран аргумент с подписью "error"
     * @param toOut аргумент
     */
    public static void printerror(Object toOut) {
        System.out.println("error: " + toOut);
    }

    /**
     * Запускает команду
     * @param userCommand
     * @return статус заверщения
     */
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
            case "execute_script":
                if (!commandsList.executeScript(userCommand[1])) return 1;
                else return scriptMode(userCommand[1]);
            default:
                if (!commandsList.noSuchCommand(userCommand[0])) return 1;
        }
        return 0;
    }
}