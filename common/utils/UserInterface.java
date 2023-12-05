package utils;

import java.util.Scanner;

public class UserInterface {
    private Scanner console;
    public UserInterface() {
        console = new Scanner(System.in);
    }

    public int getInt() {
        return Integer.parseInt(getString());
    }
    public int getInt(String prompt) {
        return Integer.parseInt(getString(prompt));
    }
    public double getDouble() {
        return Double.parseDouble(getString());
    }
    public double getDouble(String prompt) {
        return Double.parseDouble(getString(prompt));
    }
    public int menuChoice(String[] menuItems) {
        int selection = 0;
        boolean selectionOk = false;

        while(!selectionOk) {
            for (int i = 0; i < menuItems.length; ++i) {
                message("  " + (i + 1) + ") " + menuItems[i] + "\n");
            }

            message("Enter (1-" + menuItems.length + ") or <enter> to exit: ");
            String choice = getString();

            if (choice.isEmpty())
                return 0;

            if(choice.matches("[0-9]*")) {
                selection = Integer.parseInt(choice);

                if(selection == 0)
                    return 0;
            }

            if(selection < 1 || selection > menuItems.length) {
                message("'" + choice + "'-- wrong selection. Try once again.\n");
            }
            else
                selectionOk = true;
        }

        return selection;
    }
    public String getString(String prompt) {
        message(prompt);

        return getString();
    }
    public void message(String message) {
        System.out.print(message);
    }
    public String getString() {
        return console.nextLine().trim();
    }
}
