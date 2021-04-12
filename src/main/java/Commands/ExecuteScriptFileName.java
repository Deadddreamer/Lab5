package Commands;

public class ExecuteScriptFileName extends AbstarctCommand {
    public ExecuteScriptFileName() {
        super("execute_script file_name", "считать и исполнить скрипт из указанного файла");
    }

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
