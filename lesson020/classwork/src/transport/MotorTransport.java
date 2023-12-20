package transport;

public abstract class MotorTransport
        extends Transport
        implements Transmission {
    abstract void startEngine();
    abstract void stopEngine();
}
