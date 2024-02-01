package ui;

public interface MenuCommand {
    void executeCommand();

    String getMenuName();
    boolean shouldExit();
}
