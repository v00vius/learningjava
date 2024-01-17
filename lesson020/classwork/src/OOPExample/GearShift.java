package OOPExample;

public class GearShift {

        private String transmissionParameters;
        private Integer currentGear;

        public GearShift(String transmissionParameters)
        {
                this.transmissionParameters = transmissionParameters;
        }

        public Integer getCurrentGear()
        {
                return currentGear;
        }

        public void setCurrentGear(Integer currentGear)
        {
                this.currentGear = currentGear;
        }

        public String getTransmissionParameters()
        {
                return transmissionParameters;
        }
}
