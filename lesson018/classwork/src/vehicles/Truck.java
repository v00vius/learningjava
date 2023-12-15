package vehicles;

public class Truck extends Vehicle {
    public Truck(String model) {
        super(model);
    }

    public void accelerate() {
        System.out.println("Truck " + getModel() +  " is accelerating");
    }
}
