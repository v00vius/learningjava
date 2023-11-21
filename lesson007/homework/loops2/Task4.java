package loops2;

import utils.UserInterface;

public class Task4 {
    private int number;

    public Task4(int number) {
        this.number = number;
    }

    public int sumOfDigits() {
        int sum = 0;
        int num = Math.abs(number);

        while(num > 0 ) {
            int digit = num % 10;
            num /= 10;

            System.out.println(digit);
            sum += digit;
        }

        return sum;
    }

    public static void main(String[] args) {
        Task4 calc = new Task4(new UserInterface().getInt("Enter a number: "));

         System.out.println("Sum of digit(s) is: " + calc.sumOfDigits());
    }
}
