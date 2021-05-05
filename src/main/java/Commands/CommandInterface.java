package Commands;

public interface CommandInterface {
    String getDesc();
    String getName();

    /**
     * Выполняет команду
     * @param argument аргумент команды
     * @return статус завершения команды
     */
    boolean execute(String argument);
}
