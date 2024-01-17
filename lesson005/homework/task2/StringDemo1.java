package task2;

import utils.UserInterface;

public class StringDemo1 {
        public static void main(String[] args)
        {

                UserInterface ui = new UserInterface();

                String str1 = ui.getString("Enter a word 1, please: ");
                String str2 = ui.getString("Enter a word 2, please: ");

                System.out.println("You have entered two words: \""
                                   + str1 + "\" and \"" + str2 + "\"");

                String firstHalf = str1.substring(0, str1.length() / 2);
                String secondHalf = str2.substring(str2.length() / 2 + str2.length() % 2);
                String str3 = firstHalf + secondHalf;

                System.out.println("New string is \"" + str3 + "\"");
        }
}
