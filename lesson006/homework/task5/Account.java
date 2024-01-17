package task5;

import utils.UserInterface;

public class Account {
        private String name;
        private int balance;

        public Account(String name, int balance)
        {
                this.name = name;
                this.balance = balance;
        }

        public int getBalance()
        {
                return balance;
        }

        public int getMoney()
        {
                if (balance <= 0) {
                        return 0;
                }

                // find the nearest denominator
                for (int sum = balance / 2; sum > 0; --sum) {
                        if (balance % sum == 0) {
                                balance -= sum;

                                return sum;
                        }
                }

                --balance;
                return 1;
        }

        public static void main(String[] args)
        {
                Account bankAccount = new Account("USD", new UserInterface().getInt("Deposit amount: "));

                System.out.println("Balance, USD: " + bankAccount.getBalance());

                if (bankAccount.getBalance() <= 0) {
                        System.out.println("Wrong amount: " + bankAccount.getBalance() + " USD (should be > 0), exiting.");
                        return;
                }

                int daysToCash = 0;
                int sumInCash = 0;

                while (bankAccount.getBalance() > 0) {
                        int sum = bankAccount.getMoney();
                        sumInCash += sum;
                        ++daysToCash;
                        System.out.println("Day #" + daysToCash + ", got " + sum + " USD, balance "
                                           + bankAccount.getBalance() + " USD");
                }

                System.out.println("Days to go to a Bank: " + daysToCash);
        }
}
