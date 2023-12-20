package transport;

public class Bicycle
        extends NonMotorTransport
        implements Transmission {
    @Override
    public void accelerate() {
        System.out.println("Bicycle: speed (+++)");
    }
    @Override
    public void breakDown() {
        System.out.println("Bicycle: speed (---)");
    }

    @Override
    public void gearUp() {
        System.out.println("Bicycle: shift the gear up (+)");
    }

    @Override
    public void gearDown() {
        System.out.println("Bicycle: shift the gear down (-)");
    }
}
