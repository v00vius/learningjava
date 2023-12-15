package vehicles;

public class Sedan extends Vehicle {
    public Sedan(String model) {
        super(model);
    }
    public void accelerate() {
        System.out.println("Sedan " + getModel() +  " is accelerating");
    }
}
