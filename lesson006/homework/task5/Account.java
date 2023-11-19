package task5;

import utils.UserInterface;

public class Account {
    private String name;
    private int currentAccount;

    public Account(String name, int currentAccount) {
        this.name = name;
        this.currentAccount = currentAccount;
    }

    public int getCurrentAccount() {
        return currentAccount;
    }

    public static void main(String[] args) {
        Account bankAccount = new Account("USD", new UserInterface().getInt("Deposit amount: "));

        System.out.println("Account: USD" + bankAccount.getCurrentAccount());
    }
}
