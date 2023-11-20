package task2;

import utils.UserInterface;

public class Prime {
    private int number;
    private int divider;

    public Prime(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public int getDivider() {
        return divider;
    }

    boolean isPrime() {
        for (int i = 2; i <=  number / 2; ++i) {
            if(number % i == 0) {
                divider = i;

                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Prime prime = new Prime(new UserInterface().getInt("Enter a number > 0: "));

        if(prime.getNumber() <=0 ) {
            System.out.println("Wrong number: "+ prime.getNumber() +" , exiting");
            return;
        }

        if(prime.isPrime())
            System.out.println(prime.getNumber() + ": it's prime");
        else
            System.out.println(prime.getNumber() + ": it isn't prime, divided by " + prime.getDivider());
    }
}
