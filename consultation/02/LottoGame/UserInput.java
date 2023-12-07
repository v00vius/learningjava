import java.util.Scanner;

public class UserInput {
    private Scanner scanner;

    public UserInput() {
        scanner = new Scanner(System.in);
    }

    public String  getString(String message) {
        System.out.println(message);

        return scanner.nextLine();
    }

    public int getInt (String message) {
        System.out.println(message);
        return scanner.nextInt();
    }
}
