package task5;

import task3.SumCalc2;
import utils.UserInterface;

public class SumCalc3 {
        private int number;
        private int nOdd = 0;
        private int nEven = 0;

        public SumCalc3(int number)
        {
                this.number = number;
        }

        public SumCalc3 calc()
        {
                for (int i = 0; i <= number; i++) {
                        if ((i & 1) == 0) {
                                ++nEven;
                        } else {
                                ++nOdd;
                        }
                }

                return this;
        }

        @Override
        public String toString()
        {
                return "Number of even numbers: " + nEven + ", odd numbers: " + nOdd;
        }

        public static void main(String[] args)
        {
                SumCalc3 sum = new SumCalc3(new UserInterface().getInt("Enter number: "));

                System.out.println(sum.calc());
        }
}
