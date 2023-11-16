package task4;

import utils.UserInterface;

public class StringDemo2 {
    public static void main(String[] args) {
        String myName = "Vladimir Gavrilyuk";

        System.out.println(myName);

        String message = "Hi, " + myName;
        System.out.println(message + "!");

        UserInterface ui = new UserInterface();

        String name = ui.getString("What is your name: ");
        System.out.println("Hello " + name + "!");
    }
}
