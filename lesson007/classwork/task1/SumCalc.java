package task1;

import utils.UserInterface;

public class SumCalc {
        private int number;

        public SumCalc(int number)
        {
                this.number = number;
        }

        public int getEvenSum()
        {
                int sum = 0;

                for (int i = 2; i <= number; i++) {
                        if ((i & 1) == 0) {
                                sum += i;
                        }
                }

                return sum;
        }

        public static void main(String[] args)
        {
                SumCalc calc = new SumCalc(new UserInterface().getInt("Enter a number > 0: "));
                int sum = calc.getEvenSum();

                System.out.println("The sum of even numbers is " + sum);
        }
}
