import utils.UserInterface;

public class Test2 {
        public static void main(String[] args)
        {
                UserInterface ui = new UserInterface();
                int a = ui.getInt("Enter the number x: ");
                int b = ui.getInt("Enter the number y: ");
                int c = ui.getInt("Enter the number z: ");

                System.out.println("Numbers: " + a + ", " + b + ", " + c);
        }
}
