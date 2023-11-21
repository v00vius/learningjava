package loops;

import utils.UserInterface;

public class Calc2 {
    private int number;

    public Calc2(int number) {
        this.number = number;
    }

    public void multiplication() {
        for (int i = 0, mul = 0; i <= number; ++i, mul += number) {
            System.out.println(i + ") " + mul);
        }

    }

    public static void main(String[] args) {
        Calc2 calc = new Calc2(new UserInterface().getInt("Enter number > 0: "));

        calc.multiplication();
    }
}
