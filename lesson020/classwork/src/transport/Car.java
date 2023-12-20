package transport;

public class Car
        extends MotorTransport {
    @Override
    void startEngine() {
        System.out.println("Car: the engine has started");
    }

    @Override
    void stopEngine() {
        System.out.println("Car: the engine has stopped");
    }

    @Override
    public void gearUp() {
        System.out.println("Car: shift the gear up (+)");
    }

    @Override
    public void gearDown() {
        System.out.println("Car: shift the gear down (-)");

    }

    @Override
    public void accelerate() {
        System.out.println("Car: speed (+++)");
    }

    @Override
    public void breakDown() {
        System.out.println("Car: speed (---)");
    }
}
