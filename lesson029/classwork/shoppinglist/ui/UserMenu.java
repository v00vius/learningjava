package shoppinglist.ui;

import java.util.List;
import java.util.Scanner;

public class UserMenu {
    private final List<MenuCommand> commands;

    public UserMenu(List<MenuCommand> commands) {
        this.commands = commands;
    }

    public void startUserMenu() {
        while (true) {
            for (int i = 0; i < commands.size(); i++) {
                System.out.println(i + ". " + commands.get(i).getMenuName());
            }
            System.out.println("Make your choice: ");
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();
            commands.get(userInput).executeCommand();
        }
    }
}
