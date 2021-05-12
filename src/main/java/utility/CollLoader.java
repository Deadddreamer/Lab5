package utility;

import Data.Organization;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.io.StreamException;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;


public class CollLoader {
    private String env;
    private XStream xs = new XStream();

    public CollLoader(String env){
        this.env = env;
    }
    public HashMap<Integer, Organization> load(){
        if (System.getenv().get(env) != null) {
            try (FileReader collectionFileReader = new FileReader(new File(System.getenv().get(env)))){
            Path p = Paths.get(System.getenv().get(env));
            if (p.toRealPath().toString().length() > 3 && p.toRealPath().toString().trim().startsWith("/dev")) System.exit(0);
            HashMap<Integer,Organization> collection;
            collection = (HashMap) xs.fromXML(collectionFileReader);
            return collection;
            } catch (FileNotFoundException e) {
                Console.printerror("Ошибка, где файл?");}
            catch (NumberFormatException | ConversionException exception){
                Console.printerror("Ошибка в коллекции файла");
                System.exit(0); }
            catch (StreamException exception){
                Console.printerror("Файл пуст или повреждён,при сохранении файл будет перезаписан");
            } catch (InvalidPathException e) {
                Console.printerror("ЫыЫыыЫ");
                System.exit(0);
            } catch (IOException e) {
                Console.printerror("ЫыыЫыЫы");
                System.exit(0);
            }

        }
        else {Console.printerror("Системная переменная с загрузочным файлом не найдена!");
        System.exit(0);}
        return new HashMap<>();
    }
    public void writeColl(HashMap<Integer,Organization> collection){
        if (System.getenv().get(env) != null) {try {
            OutputStream os = new FileOutputStream(new File(System.getenv().get(env)));
            Writer osr = new OutputStreamWriter(os);
            osr.write(xs.toXML(collection));
            osr.close();
        } catch (IOException e) {
            Console.printerror("Ошибка");
        }


        }
    }
}
