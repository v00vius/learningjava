package transport;

public class Truck
        extends MotorTransport {
        @Override
        void startEngine()
        {
                System.out.println("Truck: the engine has started");
        }

        @Override
        void stopEngine()
        {
                System.out.println("Truck: the engine has stopped");
        }

        @Override
        public void gearUp()
        {
                System.out.println("Truck: shift the gear up (+)");
        }

        @Override
        public void gearDown()
        {
                System.out.println("Truck: shift the gear down (-)");

        }

        @Override
        public void accelerate()
        {
                System.out.println("Truck: speed (+++)");
        }

        @Override
        public void breakDown()
        {
                System.out.println("Truck: speed (---)");
        }
}
