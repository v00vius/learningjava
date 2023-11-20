package task3;

import utils.UserInterface;

public class SumCalc2 {
    public int sumThemAll() {
        UserInterface ui = new UserInterface();
        int sum = 0;
        int number;


        for(int counter = 0; true; ++counter, sum += number) {
            number = ui.getInt("Sum:" + sum + ", enter a number #" + counter + ": ");

            if(number == -1)
                break;
        }

        return sum;
    }

    public static void main(String[] args) {
        SumCalc2 calc = new SumCalc2();

        int sum = calc.sumThemAll();
        System.out.println("Done. The sum is: " + sum);
    }
}
