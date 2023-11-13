package test1;

public class Vehicle {
    private String model;
    private int engineDisplacement;
    private String trim;
    private boolean isManualTransmission;

    public Vehicle(String model, int engineDisplacement, String trim, boolean isManualTransmission) {
        this.model = model;
        this.engineDisplacement = engineDisplacement;
        this.trim = trim;
        this.isManualTransmission = isManualTransmission;

        System.out.println("The vehicle '" + model + "' has created");
    }

    public void horn(int seconds) {
        System.out.println("Horn " + seconds + " seconds");
    }

    public void move() {
        System.out.println("The vehicle '" + model + "' has started movement");
    }

    public int stop() {
        System.out.println("The vehicle '" + model + "' has stopped");
        return 500;
    }

    public static void main(String[] args) {
        Vehicle car = new Vehicle("Ford Shelby", 5000, "Orange", true);

        car.horn(3);
        car.move();
        car.stop();

    }

}
