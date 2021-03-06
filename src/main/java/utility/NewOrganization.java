package utility;

import Data.Address;
import Data.Coordinates;
import Data.OrganizationType;
import Exceptions.ScriptError;
import Main.Main;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс который запрашивает данные для создания нового элемента.
 */
public class NewOrganization {
    private Scanner scanner;
    private boolean scriptMode;
    public NewOrganization(Scanner scanner){
        this.scanner = scanner;

    }

    /**
     * @return возвращает текущий сканер
     */
    public Scanner getScanner(){
        return scanner;
    }

    /**
     * Устанавливает сканер в режим пользовательского мода
     * @param scanner
     */
    public void userScanner(Scanner scanner){
        this.scanner = scanner;
    }

    /**
     * Устанавливает режим скрипт мода
     */
    public void setScriptMode() {
        scriptMode = true;
    }

    /**
     * Устанавливает интерактивный режим
     */
    public void setInteractiveMod(){
        scriptMode = false;
    }

    /**
     * Запрашивает id нового элемента
     * @return id
     * @throws ScriptError если в скрипте что-то неверно
     */
    public Integer askId() throws ScriptError{;
        Integer id;
        String idstr;
        while (true){
            try {
                Console.println("Введите id");
                Console.print(Main.Type2);
                idstr = scanner.nextLine().trim();
                id = Integer.parseInt(idstr);
                if (id <= 0) throw new NumberFormatException();
                break;

            } catch (NumberFormatException e) {
                Console.printerror("Неверный формат");
                if(scriptMode) throw new ScriptError();
            }
        }
        return id;
    }

    /**
     * Запрашивает name нового элемента
     * @return name
     * @throws ScriptError если в скрипте что-то неверно
     */
    public String askName() throws ScriptError{
        String name;
        while (true) {
            try {
                Console.println("Введите имя:");
                Console.print(Main.Type2);
                name = scanner.nextLine().trim();
                if (scriptMode) Console.println(name);
                if(name.equals("")) throw new NoSuchElementException();
                break;
            }
            catch (NoSuchElementException exception) {
                Console.printerror("Имя не распознано!");
                if(scriptMode) throw new ScriptError();
            }
             catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                 if(scriptMode) throw new ScriptError();
            }
        }
        return name;
    }

    /**
     * Запрашивает x нового элемента
     * @return x
     * @throws ScriptError если в скрипте что-то неверно
     */
    public Long askX() throws ScriptError{
    Long x;
    String xstr;
        while (true) {
            try {
             Console.println("Введите координату X:");
             Console.print(Main.Type2);
             xstr = scanner.nextLine().trim();
                if (scriptMode) Console.println(xstr);
                x = Long.parseLong(xstr);
                if(xstr.equals("")) throw new NoSuchElementException();
                break;
                }
            catch (NumberFormatException e) {
            Console.printerror("Неверный формат");
                if(scriptMode) throw new ScriptError();
                 }
        }
        return x;
    }

    /**
     * Запрашивает y нового элемента
     * @return y
     * @throws ScriptError если в скрипте что-то неверно
     */
    public Integer askY() throws ScriptError{
        String ystr;
        Integer y;
        while (true) {
        try {Console.println("Введите координату Y:");
            Console.print(Main.Type2);
            ystr = scanner.nextLine().trim();
            y = Integer.parseInt(ystr);
            if(ystr.equals("")) throw new NoSuchElementException();
            if (scriptMode) Console.println(ystr);
            break;
        } catch (NumberFormatException e) {
            Console.printerror("Неверный формат");
            if(scriptMode) throw new ScriptError();
         }
        }
        return y;
    }

    /**
     * Возвращает coordinates нового элементы
     * @return coordinates
     * @throws ScriptError если в скрипте что-то неверно
     */
    public Coordinates askCoordinates() throws ScriptError{
        Long x;
        Integer y;
        x = askX();
        y = askY();
        return new Coordinates(x,y);
    }

    /**
     * Запрашивает AnnualturnOver нового элементы
     * @return AnnualturnOver
     * @throws ScriptError если в скрипте что-то неверно
     */
    public Integer askAnnualturnOver() throws ScriptError{
        String strAnnual;
        Integer annual;
        while (true) {
            try {
                Console.println("Введите годовой оборот:");
                Console.print(Main.Type2);
                strAnnual = scanner.nextLine().trim();
                annual = Integer.parseInt(strAnnual);
                if (annual <= 0) throw new NumberFormatException();
                if (scriptMode) Console.println(strAnnual);
                break;
            }
            catch (NoSuchElementException exception) {
                Console.printerror("Годовой оборот не распознан!");
                if(scriptMode) throw new ScriptError();
            }
            catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                if(scriptMode) throw new ScriptError();
            }
            catch (NumberFormatException e) {
                Console.printerror("Неверный формат");
                if(scriptMode) throw new ScriptError();
            }
        }
        return annual;
    }

    /**
     * Запрашивает Employees нового элементы
     * @return Employees
     * @throws ScriptError если в скрипте что-то неверно
     */
    public Long askEmployees() throws ScriptError{
        String strEmployees;
        Long employees;
        while (true){
            try {
                Console.println("Введите колличество работников:");
                Console.print(Main.Type2);
                strEmployees = scanner.nextLine().trim();
                employees = Long.parseLong(strEmployees);
                if (employees <= 0) throw new NumberFormatException();
                if (scriptMode) Console.println(strEmployees);
                break;
            }
            catch (NoSuchElementException exception) {
                Console.printerror("Колличество работников не распознано!");
            }
            catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
            }
            catch (NumberFormatException e) {
                Console.printerror("Неверный формат");
                if(scriptMode) throw new ScriptError();
            }

        }
        return employees;
    }

    /**
     * Запрашивает Type нового элементы
     * @return Type
     * @throws ScriptError если в скрипте что-то неверно
     */
    public OrganizationType askType() throws ScriptError{
        String strType;
        OrganizationType type;
        while (true) {
            try {
                Console.println("Список категорий - " + OrganizationType.nameList());
                Console.println("Введите категорию:");
                Console.print(Main.Type2);
                strType = scanner.nextLine().trim();
                type = OrganizationType.valueOf(strType.toUpperCase());
                if (scriptMode) Console.println(strType);
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Категория не распознана!");
                if(scriptMode) throw new ScriptError();
            }
            catch (IllegalArgumentException exception) {
                Console.printerror("Неверный формат");
                if(scriptMode) throw new ScriptError();
            }
        }
        return type;
    }

    /**
     * Запрашивает Street нового элементы
     * @return Street
     * @throws ScriptError если в скрипте что-то неверно
     */
    public String askStreet() throws ScriptError{
        String street;
        while (true){
            try {
                Console.println("Введите улицу:");
                street = scanner.nextLine().trim();
                if(street.equals("")) throw new NoSuchElementException();
                if (scriptMode) Console.println(street);
                break;

            }
            catch (NoSuchElementException exception) {
                Console.printerror("Улица не распознана!");
                if(scriptMode) throw new ScriptError();
            }
        }
        return street;
    }

    /**
     * Запрашивает Zipcode нового элементы
     * @return Zipcode
     * @throws ScriptError если в скрипте что-то неверно
     */
    public String askZipcode() throws ScriptError{
        String zipcode;
        while (true){
            try {
                Console.println("Введите индекс:");
                zipcode = scanner.nextLine().trim();
                if(zipcode.equals("")) throw new NoSuchElementException();
                if (scriptMode) Console.println(zipcode);
                break;
            }
            catch (NoSuchElementException exception) {
                Console.printerror("Индекс не распознан!");
                if(scriptMode) throw new ScriptError();
            }
        }
        return zipcode;

    }

    /**
     * Возвращает Adress нового элементы
     * @return Adress
     * @throws ScriptError если в скрипте что-то неверно
     */
    public Address askAdress() throws ScriptError{
        String street;
        String zipcode;
        street = askStreet();
        zipcode = askZipcode();
        return new Address(street,zipcode);
    }
}
