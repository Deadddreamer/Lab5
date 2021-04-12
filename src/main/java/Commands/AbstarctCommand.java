package Commands;

import java.util.ArrayList;

public abstract class AbstarctCommand implements CommandInterface{
    private String name;
    private String desc;
    public AbstarctCommand (String name, String desc){
        this.name = name;
        this.desc = desc;
    }
    public String getName(){
        return name;
    }
    public String getDesc(){
        return desc;
    }




}

