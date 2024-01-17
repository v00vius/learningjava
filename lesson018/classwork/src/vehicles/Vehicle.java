package vehicles;

abstract class Vehicle {
        private String model;

        public Vehicle(String model)
        {
                this.model = model;
        }

        public String getModel()
        {
                return model;
        }

        abstract void accelerate();
}
