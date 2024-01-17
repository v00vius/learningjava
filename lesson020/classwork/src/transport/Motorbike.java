package transport;

public class Motorbike
        extends MotorTransport {
        @Override
        void startEngine()
        {
                System.out.println("Motor bike: the engine has started");
        }

        @Override
        void stopEngine()
        {
                System.out.println("Motor bike: the engine has stopped");
        }

        @Override
        public void gearUp()
        {
                System.out.println("Motor bike: shift the gear up (+)");
        }

        @Override
        public void gearDown()
        {
                System.out.println("Motor bike: shift the gear down (-)");

        }

        @Override
        public void accelerate()
        {
                System.out.println("Motor bike: speed (+++)");
        }

        @Override
        public void breakDown()
        {
                System.out.println("Motor bike: speed (---)");
        }
}
