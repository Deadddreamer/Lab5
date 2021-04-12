package Commands;

public class ReplaceIfGreaterElementNull extends AbstarctCommand {
    public ReplaceIfGreaterElementNull() {
        super("replace_if_greater null {element}","заменить значение по ключу, если новое значение больше старого");
    }

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
