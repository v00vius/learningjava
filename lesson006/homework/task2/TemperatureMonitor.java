package task2;

public class TemperatureMonitor {
    static private double threshold = 100.0;
    private String name;
    private double temperature1;
    private double temperature2;

    public TemperatureMonitor(String name,  double temperature1, double temperature2) {
        this.name = name;
        this.temperature1 = temperature1;
        this.temperature2 = temperature2;
    }

    public boolean itWorks() {
        return temperature1 > threshold && temperature2 < threshold;
    }

    @Override
    public String toString() {
        return "\"" + name + "\": temperature1=" + temperature1 + "°C, temperature2=" + temperature2 + "°C";
    }

    public static void main(String[] args) {
        TemperatureMonitor tm1 = new TemperatureMonitor("Device A", 150, 0);
        TemperatureMonitor tm2 = new TemperatureMonitor("Device B", 0, 0);
        TemperatureMonitor tm3 = new TemperatureMonitor("Device C", 101, 102);
        TemperatureMonitor tm4 = new TemperatureMonitor("Device D", 0, 102);

        System.out.println(tm1 + ", works: " + tm1.itWorks());
        System.out.println(tm2 + ", works: " + tm2.itWorks());
        System.out.println(tm3 + ", works: " + tm3.itWorks());
        System.out.println(tm4 + ", works: " + tm4.itWorks());
    }
}
