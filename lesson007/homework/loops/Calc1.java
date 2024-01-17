package loops;

import utils.UserInterface;

public class Calc1 {
        private int number;

        public Calc1(int number)
        {
                this.number = number;
        }

        public void power3()
        {
                for (int i = 1; i <= number; ++i) {
                        System.out.println(i + " to power 3 = " + i * i * i);
                }
        }

        public static void main(String[] args)
        {
                UserInterface ui = new UserInterface();

                Calc1 calc = new Calc1(ui.getInt("Enter a number > 0: "));

                calc.power3();
        }
}
