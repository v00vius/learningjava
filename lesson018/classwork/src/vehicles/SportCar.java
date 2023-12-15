package vehicles;

public class SportCar extends Vehicle {
    public SportCar(String model) {
        super(model);
    }
    public void accelerate() {
        System.out.println("SportCar " + getModel() +  " is accelerating");
    }
}
