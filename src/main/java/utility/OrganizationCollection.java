package utility;
import Data.Organization;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.io.StreamException;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Класс для работы с коллекцией, предоставляет методы доступа и обработки, используется командами.
 */
public class OrganizationCollection {
    private LocalDateTime initTime = null;
    private LocalDateTime lastSave = null;
    private HashMap<Integer,Organization> hm1 = new HashMap<>();
    XStream xs = new XStream();
    private FileReader file;
    private CollLoader collLoader;
    public OrganizationCollection(CollLoader collLoader){
        this.collLoader = collLoader;
        loadColl();
    }
    /**
     * Метод для загрузги коллекции, защищает от неправильных ссылок и
     */
    public void loadColl(){
            hm1 = collLoader.load();
            initTime = LocalDateTime.now();
            for(Integer i: hm1.keySet()){
                Organization org = hm1.get(i);
                if(org.getId() == null || org.getId()<0 || org.getName().trim().equals("") || org.getCoordinates()== null
                        || org.getEmployeesCount() == null || org.getEmployeesCount() <=0 || org.getAnnualTurnover() == null ||
                        org.getAnnualTurnover() <= 0 || org.getType() == null || org.getPostalAddress() == null){ Console.printerror("Неправильный файл"); System.exit(0);}

            }


    }

    /**
     * Метод выводит коллекцию
     */
    public void outcall() {
        for (Map.Entry entry : hm1.entrySet()) {
            System.out.println(entry);
        }
    }

    /**
     * @return возвращает размер коллекции
     */
    public int collSize(){
        return hm1.size();
    }

    /**
     * @param key ключ который мы хотим проверить
     * @return проверяет ключ на существование в коллекции
     */

    public boolean trykey(Integer key){
       if (hm1.get(key) == null){
       return false;}
        else {return true;}
    }

    /**
     * Удаляет элемент из коллекции
     * @param key ключ удаляемой коллекции
     */
    public void removeOrg(Integer key){
        hm1.remove(key);
    }

    /**
     * Удаляет всю коллекцию
     */
    public void clearColl(){
        hm1.clear();
    }

    /**
     * Удаляет все элементы коллекции с ключом меньше заданного
     * @param key заданный ключ
     */
    public void removeLowerKey(Integer key){
       for (Integer i: hm1.keySet() ){
           if(i.compareTo(key) < 0){
               hm1.remove(i);
           }
       }

    }

    /**
     * Сохраняет коллекцию в файл
     */
    public void saveColl(){

        collLoader.writeColl(hm1);
        lastSave = LocalDateTime.now();
    }

    /**
     * Добавляет организацию в коллекцию
     * @param key ключ огранизации
     * @param organization организация
     */
    public void addOrg(Integer key, Organization organization){
        hm1.put(key, organization);

    }

    /**
     * @return имя типа коллекции
     */
    public String collTypy(){
        return hm1.getClass().getName();
    }

    /**
     * @return время последнего входа в программу
     */
    public LocalDateTime getInitTime() {
        return initTime;
    }

    /**
     * @return время последнего сохранения коллекции
     */
    public LocalDateTime getLastSave(){
        return lastSave;
    }

    /**
     * @return сумму поля employees всех эементов коллекции
     */
    public Long sumEmployees(){
        Long sum = 0L;
       for(Integer i: hm1.keySet()){
           Organization organization = hm1.get(i);
           sum += organization.getEmployeesCount();
       }
       return sum;
    }

    /**
     * Выводит значение поля employees меньшие чем заданное число
     * @param argument
     */
    public void lessThanEmployees(Long argument){
        for(Integer i: hm1.keySet()){
            Organization organization = hm1.get(i);
            if(organization.getEmployeesCount() < argument){
                Console.println(organization.getEmployeesCount() + " работают в организации " + organization.getName());
            }
        }
    }

    /**
     * Выводит значение поля employees у всех элементов
     */
    public void printEmployees(){
        for(Integer i: hm1.keySet()){
            Organization organization = hm1.get(i);
            Console.println(organization.getEmployeesCount() + " работают в организации " + organization.getName());
        }
    }

    /**
     * Ищет ключ элемента по id
     * @param argument id
     * @return ключ элемента
     */
    public Integer findId(Integer argument){
        Integer key = null;
        for(Integer i: hm1.keySet()){
            Organization organization = hm1.get(i);
            if(organization.getId().equals(argument)){
                key = i;
            }
        }
        return key;
    }

    /**
     * Удаляет все элементы меньшие чем заданый
     * @param newOrg заданный элемент
     */
    public void removeLower(Organization newOrg){
        for (Integer i: hm1.keySet()){
            Organization oldOrg = hm1.get(i);
            if(newOrg.compareTo(oldOrg) > 0){
                hm1.remove(i);
            }
        }

    }

    /**
     * Ищет в коллекции элемент равный заданному
     * @param findeOrg заданная организация
     * @return найденую организацию или null
     */
    public Organization findByInsert(Organization findeOrg){
        for(Integer i: hm1.keySet()){
            Organization organization = hm1.get(i);
            if(organization.equals(findeOrg)){
                return organization;
            }
        }
        return null;
    }

    /**
     * Сравнивает две организации
     * @param key ключ одной организации
     * @param organization другой организации
     * @return результат сравнения
     */
    public boolean compareTwo(Integer key, Organization organization){
        return organization.compareTo(hm1.get(key)) > 0;
    }

    /**
     * Заменияет организацию ключа
     * @param key ключ
     * @param organization новая организация
     */
    public void replaceOrg(Integer key,Organization organization){
        hm1.replace(key,organization);
    }

    /**
     * Генирирует id для новых элементов коллекции
     * @return новый id
     */
   public Integer createId(){
        for(Integer i: hm1.keySet()){
            if(hm1.size() == i)  return hm1.get(i).getId() + 1;
        }
    return 1;
   }
}
