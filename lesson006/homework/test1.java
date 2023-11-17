import utils.UserInterface;

import javax.sound.midi.Soundbank;
import java.net.SocketOption;

public class test1 {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();

        int num1 = ui.getInt("Enter the number that is greater than 0 and less than 1000: ");

        if(num1 <= 0  || num1 > 1000) {
            System.out.println("Invalid number: " + num1);
            return;
        }

        System.out.println("You've entered: " + num1);

        int diff1 = Math.abs(10 - num1);
        int diff2 = Math.abs(100 - num1);
        int diff3 = Math.abs(1000 - num1);

        if(diff1 < diff2 && diff1 < diff3) {
            System.out.println(num1 + " is the closest to 10");
        }
        else if(diff2 < diff1 && diff2 < diff3) {
            System.out.println(num1 + " is the closest to 100");
        }
        else {
            System.out.println(num1 + " is the closest to 1000");
        }
    }
}
