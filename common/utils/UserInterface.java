package utils;

import java.util.Scanner;

public class UserInterface {
    private Scanner console;
    public UserInterface() {
        console = new Scanner(System.in);
    }

    public void message(String message) {
        System.out.print(message);
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
    public String getString(String prompt) {
        message(prompt);

        return getString();
    }
    public String getString() {
        return console.nextLine().trim();
    }
}
