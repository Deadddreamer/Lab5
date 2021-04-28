package utility;
import Data.Organization;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.security.ForbiddenClassException;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class OrganizationCollection {
    private LocalDateTime initTime = null;
    private LocalDateTime lastSave = null;

    FileReader file;
    FileReader test;
    XStream xs = new XStream();

    {
        try {
            file = new FileReader("C:\\Users\\vital\\IdeaProjects\\Lab5mav\\l");
            test = new FileReader("C:\\Users\\vital\\IdeaProjects\\Lab5mav\\l");

          Object tryFile = xs.fromXML(test);
          initTime = LocalDateTime.now();

        } catch (FileNotFoundException e) {
            Console.printerror("Файл не найден");
            System.exit(0);
        }
          catch (StreamException exception){
            Console.printerror("Файл повреждён");
            System.exit(0);
        }
    }

    HashMap<Integer,Organization> hm1 = (HashMap) xs.fromXML(file);
    ArrayList<Integer> keys = new ArrayList<>(hm1.keySet());
    public void outcall() {
        for (Object i :
                hm1.keySet()) {
            System.out.println(hm1.get(i));
        }
    }
    public int collSize(){
        return hm1.size();
    }
    public boolean trykey(Integer id){
       if (hm1.get(id) == null){
       return false;}
        else {return true;}
    }
    public void removeOrg(Integer key){
        hm1.remove(key);
    }
    public void clearColl(){
        hm1.clear();
    }
    public void removeLowerKey(Integer key){
       for (Integer i: keys ){
           if(i.compareTo(key) < 0){
               hm1.remove(i);
           }
       }

    }
    public void saveColl(){

        try {
            OutputStream os = new FileOutputStream("C:\\Users\\vital\\IdeaProjects\\Lab5mav\\l");
            Writer osr = new OutputStreamWriter(os);
            osr.write(xs.toXML(hm1));
            osr.close();
            lastSave = LocalDateTime.now();
        } catch (IOException e) {
            Console.printerror("Ошибка");
        }
    }
    public void addOrg(Integer key, Organization organization){
        hm1.put(key, organization);

    }
    public String collTypy(){
        return hm1.getClass().getName();
    }

    public LocalDateTime getInitTime() {
        return initTime;
    }
    public LocalDateTime getLastSave(){
        return lastSave;
    }
    public Long sumEmployees(){
        Long sum = 0L;
       for(Integer i: keys){
           Organization organization = hm1.get(i);
           sum += organization.getEmployeesCount();
       }
       return sum;
    }
    public void lessThanEmployees(Long argument){
        for(Integer i: keys){
            Organization organization = hm1.get(i);
            if(organization.getEmployeesCount() < argument){
                Console.println(organization.getEmployeesCount() + " работают в организации " + organization.getName());
            }
        }
    }
    public void printEmployees(){
        for(Integer i: keys){
            Organization organization = hm1.get(i);
            Console.println(organization.getEmployeesCount() + " работают в организации " + organization.getName());
        }
    }
    public Integer findId(Integer argument){
        Integer key = null;
        for(Integer i: keys){
            Organization organization = hm1.get(i);
            if(organization.getId().equals(argument)){
                key = i;
            }
        }
        return key;
    }
    public void removeLower(Organization newOrg){
        for (Integer i: keys){
            Organization oldOrg = hm1.get(i);
            if(newOrg.compareTo(oldOrg) > 0){
                hm1.remove(i);
            }
        }

    }
    public Organization findByInsert(Organization findeOrg){
        for(Integer i: keys){
            Organization organization = hm1.get(i);
            if(organization.equals(findeOrg)){
                return organization;
            }
        }
        return null;
    }
    public boolean compareTwo(Integer key, Organization organization){
        return organization.compareTo(hm1.get(key)) > 0;
    }
    public void replaceOrg(Integer key,Organization organization){
        hm1.replace(key,organization);
    }
   public Integer createId(){
        for(Integer i: keys){
            if(hm1.size() == i)  return hm1.get(i).getId() + 1;
        }
    return 1;
   }
}
