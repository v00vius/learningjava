package vehicles;

public class App {
        public static void main(String[] args)
        {
                Vehicle[] vehicles = {
                        new Truck("Ford F350 V8 6.7L 475hp       (0-200 km/h in 145s) "),
                        new Sedan("Audi RS3 Sedan 2.5L 400hp     (0-200 km/h in 13.7s)"),
                        new SportCar("Ford Shelby V8 5.7L 660hp  (0-200 km/h in 12.3s)")
                };

                for (int i = 0; i < vehicles.length; i++) {
                        vehicles[i].accelerate();
                }
        }
}
