package Commands;


public abstract class AbstarctCommand implements CommandInterface{
    private String name;
    private String desc;
    public AbstarctCommand (String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    /**
     * Getter name
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * Getter description
     * @return desc
     */
    public String getDesc(){
        return desc;
    }
}

