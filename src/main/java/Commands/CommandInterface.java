package Commands;

public interface CommandInterface {
    String getDesc();
    String getName();
    boolean execute(String argument);
}
