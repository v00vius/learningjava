package OOPExample;

public class BiCycle extends NonMotorizedVehicle implements GearShiftOperation {

        private GearShift gearShift;

        public BiCycle(String model, Integer speed, GearShift gearShift)
        {
                super(model, speed);
                this.gearShift = gearShift;
        }

        @Override
        public void changeGear(boolean isUp)
        {
                Integer currentGear = gearShift.getCurrentGear();

                if (isUp) {
                        gearShift.setCurrentGear(currentGear + 1);
                } else {
                        gearShift.setCurrentGear(currentGear - 1);
                }
        }
}
