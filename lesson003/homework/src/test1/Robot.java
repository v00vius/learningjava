package test1;

import java.io.PrintStream;

public class Robot {
    private String make;
    private String model;

    private double amount;
    private double exchangeRate = 1.2;


    public Robot(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public  double covertToEUR() {
        return exchangeRate * amount;
    }
    public double getAmount() {
        return amount;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void sayHello() {
        System.out.printf("Hello! I am  '%s' robot, model '%s'\n", getMake(), getModel());
    }

    public static void main(String[] args) {
        Robot robot = new Robot("The best", "R001");

        robot.sayHello();
        robot.setAmount(1000.0);

        double euros = robot.covertToEUR();

        System.out.printf("I've had %10.2f USD, it is equivalent of %10.2f EUR (the rate is %10.2f)\n",
                                robot.getAmount(),
                                euros,  robot.getExchangeRate());
    }
}
