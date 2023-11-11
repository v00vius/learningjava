package task4;

import java.io.File;
import java.util.Scanner;

public class WeatherData {
    static private final int maxWeatherData = 64;
    public WeatherData(String fileName) {
        setPlace(fileName);
        dailyWeatherData = new DailyWeather[maxWeatherData];
        nWeatherData = 0;
        loadWeatherData(fileName);
    }
    public void loadWeatherData(String fileName) {
/*
        File fp = new File(fileName);

        System.exit(1);

        Scanner sc = new Scanner(fp);

        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] strings = s.split(";", 8);

//            dailyWeatherData[nWeatherData++] = new DailyWeather(strings[0]);
        }
*/
    }
    public void updateStats() {

    }

    public String place() { return place; }
    public void setPlace(String place) { this.place = place; }

    //  protected:
    protected String place;
    protected int nWeatherData;
    protected DailyWeather[] dailyWeatherData;
}
/*
0 - Date
1 - Sol
2 - Air Temperature (°F | °C), min
3 - Air Temperature (°F | °C), max
4 - Pressure (Pa)
5 - Sunrise
6 - Sunset
           0;   1;   2;     3;  4;    5;    6
Nov. 1, 2023;3995;10°F;-103°F;695;05:34;17:24
*/