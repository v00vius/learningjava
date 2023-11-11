package task4;

import java.io.File;

public class WeatherData {
    static private final int maxWeatherData = 64;
    public WeatherData(String fileName) {
        setPlace(fileName);
        loadWeatherData(fileName);
    }
    public void loadWeatherData(String fileName) {
        dailyWeatherData = new DailyWeather[maxWeatherData];
        File fp = new File(fileName);
    }
    public void updateStats() {

    }

    public String place() { return place; }
    public void setPlace(String place) { this.place = place; }

    //  protected:
    protected String place;
    protected DailyWeather[] dailyWeatherData;
}
