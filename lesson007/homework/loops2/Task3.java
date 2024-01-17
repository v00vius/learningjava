package loops2;

import utils.UserInterface;

public class Task3 {
        private String hello;
        private int attempts;

        public Task3(String hello)
        {
                this.hello = hello;
                attempts = 0;
        }

        public boolean isEqual(String word)
        {
                boolean ok = hello.equals(word);

                if (!ok) {
                        ++attempts;
                }

                return ok;
        }

        public int getAttempts()
        {
                return attempts;
        }

        public static void main(String[] args)
        {
                UserInterface ui = new UserInterface();

                Task3 hello = new Task3("hello");

                while (!hello.isEqual(ui.getString("Hello!\n")))
                        ;

                System.out.println("Total attempts: " + (hello.getAttempts() + 1));
        }
}
