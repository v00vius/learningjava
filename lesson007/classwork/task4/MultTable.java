package task4;

import utils.UserInterface;

public class MultTable {
        private int num1;
        private int num2;

        public MultTable(int num1, int num2)
        {
                this.num1 = num1;
                this.num2 = num2;
        }

        public void print()
        {
                for (int i = 1; i <= num1; i++) {
                        for (int j = 1; j < num2; j++) {
                                System.out.printf("%5d", i * j);
                        }

                        System.out.println();
                }
        }

        public static void main(String[] args)
        {
                UserInterface ui = new UserInterface();
                MultTable mt = new MultTable(ui.getInt("Number 1: "), ui.getInt("Number 2: "));

                mt.print();
        }
}
