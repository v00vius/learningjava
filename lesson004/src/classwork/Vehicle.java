package classwork;

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

    public void print() {
        System.out.println("The vehicle data:");
        System.out.println("\tmodel: " + model);
        System.out.println("\tEngine displacement: " + engineDisplacement + " cc");
        System.out.println("\tTrim: " + trim);
        System.out.println("\tTransmission type: " + (isManualTransmission ? "manual" : "auto"));
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

        car.print();
        car.horn(3);
        car.move();
        int distance = car.stop();

        System.out.println("Distance passed: " + distance + " km");
    }

}
