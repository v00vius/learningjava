package task4;

public class WeatherData {
    static private final int maxWeatherData = 64;
    public WeatherData(String fileName) {
        setPlace(fileName);

    }

    public String place() { return place; }
    public void setPlace(String place) { this.place = place; }

    //  protected:
    protected String place;
    protected DailyWeather[] dailyWeatherData;
}
