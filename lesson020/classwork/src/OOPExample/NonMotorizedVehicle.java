package OOPExample;

public class NonMotorizedVehicle extends Vehicle {

        public NonMotorizedVehicle(String model, Integer speed)
        {
                super(model, speed);
        }

        @Override
        void accelerate()
        {
                setSpeed(getSpeed() + 10);
                System.out.println("Accelerate. Current speed: " + getSpeed());
        }

        @Override
        void brake()
        {
                if (getSpeed() > 10) {
                        setSpeed(getSpeed() - 10);
                        System.out.println("Brake. Current speed: " + getSpeed());
                } else {
                        setSpeed(0);
                        System.out.println("Car stopped.");
                }
        }

}
