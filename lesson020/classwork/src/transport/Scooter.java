package transport;

public class Scooter
        extends NonMotorTransport {
    @Override
    public void accelerate() {
        System.out.println("Scooter: speed (+++)");
    }

    @Override
    public void breakDown() {
        System.out.println("Scooter: speed (---)");
    }
}
