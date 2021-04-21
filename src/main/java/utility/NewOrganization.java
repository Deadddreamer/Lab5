package utility;

import Data.Address;
import Data.Coordinates;
import Data.OrganizationType;
import Main.Main;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class NewOrganization {
    private Scanner scanner;
    public NewOrganization(Scanner scanner){
        this.scanner = scanner;

    }
    public Integer askId(){;
        Integer id;
        String idstr;
        while (true){
            try {
                Console.println("Введите id");
                Console.print(Main.PS2);
                idstr = scanner.nextLine().trim();
                id = Integer.parseInt(idstr);
                break;

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return id;
    }
    public String askName() {
        String name;
        while (true) {
            try {
                Console.println("Введите имя:");
                Console.print(Main.PS2);
                name = scanner.nextLine().trim();
                break;
            }
            catch (NoSuchElementException exception) {
                Console.printerror("Имя не распознано!");
            }
             catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
            }
        }
        return name;
    }
    public Long askX(){
    Long x;
    String xstr;
        while (true) {
            try {
             Console.println("Введите координату X:");
             Console.print(Main.PS2);
             xstr = scanner.nextLine().trim();
                x = Long.parseLong(xstr);
                break;
                }
            catch (NumberFormatException e) {
            e.printStackTrace();
                 }
        }
        return x;
    }
    public Integer askY(){
        String ystr;
        Integer y;
        while (true) {
        try {Console.println("Введите координату Y:");
            Console.print(Main.PS2);
            ystr = scanner.nextLine().trim();
            y = Integer.parseInt(ystr);
            break;
        } catch (NumberFormatException e) {
            e.printStackTrace();
         }
        }
        return y;
    }
    public Coordinates askCoordinates(){
        Long x;
        Integer y;
        x = askX();
        y = askY();
        return new Coordinates(x,y);
    }
    public Integer askAnnualturnOver(){
        String strAnnual;
        Integer annual;
        while (true) {
            try {
                Console.println("Введите годовой оборот:");
                Console.print(Main.PS2);
                strAnnual = scanner.nextLine().trim();
                annual = Integer.parseInt(strAnnual);
                break;
            }
            catch (NoSuchElementException exception) {
                Console.printerror("Годовой оборот не распознан!");
            }
            catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
            }
        }
        return annual;
    }

    public Long askEmployees(){
        String strEmployees;
        Long employees;
        while (true){
            try {
                Console.println("Введите колличество работников:");
                Console.print(Main.PS2);
                strEmployees = scanner.nextLine().trim();
                employees = Long.parseLong(strEmployees);
                break;
            }
            catch (NoSuchElementException exception) {
                Console.printerror("Колличество работников не распознано!");
            }
            catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
            }

        }
        return employees;
    }

    public OrganizationType askType() {
        String strType;
        OrganizationType type;
        while (true) {
            try {
                Console.println("Список категорий - " + OrganizationType.nameList());
                Console.println("Введите категорию:");
                Console.print(Main.PS2);
                strType = scanner.nextLine().trim();
                type = OrganizationType.valueOf(strType.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Категория не распознана!");
            }
        }
        return type;
    }

    public String askStreet(){
        String street;
        while (true){
            try {
                Console.println("Введите улицу:");
                street = scanner.nextLine().trim();
                break;
            }
            catch (NoSuchElementException exception) {
                Console.printerror("Улица не распознана!");
            }
        }
        return street;
    }
    public String askZipcode(){
        String zipcode;
        while (true){
            try {
                Console.println("Введите индекс:");
                zipcode = scanner.nextLine().trim();
                break;
            }
            catch (NoSuchElementException exception) {
                Console.printerror("Индекс не распознан!");
            }
        }
        return zipcode;

    }
    public Address askAdress(){
        String street;
        String zipcode;
        street = askStreet();
        zipcode = askZipcode();
        return new Address(street,zipcode);
    }
}
