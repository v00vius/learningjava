package task4;

public class Task4Test {
    public static void main(String[] args) {
        WeatherData wd = new WeatherData("/home/vlan/IdeaProjects/learningjava/lesson003/mars-weather-data.csv");

        wd.updateStats();
        wd.print();

    }
}
