package utility;

import Data.Organization;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.time.ZonedDateTimeConverter;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class Parser {

    private XStream xstream = null;

    public void init() {
        if (xstream == null) {
            xstream = new XStream(new StaxDriver());
            xstream.registerConverter(new ZonedDateTimeConverter());
//            xstream.alias("organization", Data.Organization.class);
//            xstream.alias("organizations", List.class);
        }
    }

    public void parser () {
        File f = new File("C:\\Users\\vital\\IdeaProjects\\Lab5mav\\l");
        try {
            FileReader fr = new FileReader(f);
            XStream xs = new XStream();
            HashMap<Integer, Organization> hm1 = (HashMap) xs.fromXML(fr);
            for (Integer i:
                    hm1.keySet()) {
                System.out.println(hm1.get(i));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Organization organizationFromXML(FileReader fileReader) {
        return (Organization) xstream.fromXML(fileReader);
    }

    public String objToXML(Object o) {
        return xstream.toXML(o);
    }

    public Object objFromXML(FileReader fileReader) {
        return xstream.fromXML(fileReader);
    }
}
