package utils;

import java.util.Scanner;

public class UserInterface {
    Scanner console;
    public UserInterface() {
        console = new Scanner(System.in);
    }

    public String getString(String prompt) {
        System.out.print(prompt);
        return console.nextLine();
    }
    public int getInt(String prompt) {
        return Integer.parseInt(getString(prompt));
     }
}
