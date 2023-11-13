package test1;

import java.io.PrintStream;

public class Robot {
    private String make;
    private String model;

    public Robot(String make, String model) {
        this.make = make;
        this.model = model;
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
    }
}
