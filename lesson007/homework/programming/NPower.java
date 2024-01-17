package programming;

import utils.UserInterface;

public class NPower {
        private int number;
        private int power;

        public NPower(int number, int power)
        {
                this.number = number;
                this.power = power;
        }

        public double getPowerOf()
        {
                double pow = 1.0;

                for (int i = 1; i <= power; ++i, pow *= number)
                        ;

                return pow;
        }

        public double getAvg()
        {
                double avg = 0.0;

                for (int i = 1; i <= number; avg += i++)
                        ;

                return avg / number;
        }

        public static void main(String[] args)
        {
                UserInterface ui = new UserInterface();

                int number, power;

                NPower np = new NPower(number = ui.getInt("Enter a natural number N > 0: "),
                        power = ui.getInt("Enter a natural power M > 0: "));

                System.out.println("You've had the number: " + number + ", power: " + power);
                System.out.println(number + "**" + power + " = " + np.getPowerOf());
                System.out.println("avg of sum(1 .. " + number + ") = " + np.getAvg());
        }
}
