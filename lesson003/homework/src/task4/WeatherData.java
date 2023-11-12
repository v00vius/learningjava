package task4;

import utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WeatherData {
    static private final int maxWeatherData = 64;
    public WeatherData(String fileName) {
        nWeatherData = 0;
        dailyWeatherData = new DailyWeather[maxWeatherData];
        loadWeatherData(fileName);
    }
    public void loadWeatherData(String fileName) {

        File fp = new File(fileName);

        System.out.println("# Loading data from '" + fileName + "' ...");

        if(!(fp.exists() && fp.canRead()))
            Utils.fatalExit("Error: File '" + fileName + "' doesn't exists");

        Scanner sc = null;
        try {
            sc = new Scanner(fp);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        if(!sc.hasNextLine())
            Utils.fatalExit("Error: File '" + fileName + "' is empty");

        setPlace(sc.nextLine());

        while(sc.hasNextLine()) {
            String[] strings = sc.nextLine().split(";", 8);

            dailyWeatherData[nWeatherData++] = new DailyWeather(strings[0],
                                                Integer.parseInt(strings[1]),
                                                Utils.fromFahrenheit2Celsius(Integer.parseInt(strings[2])),
                                                Utils.fromFahrenheit2Celsius(Integer.parseInt(strings[3])),
                                                Integer.parseInt(strings[4])
                                               );

        }
        System.out.println("# Done");
    }
    public void print() {
        System.out.println(place());
        System.out.println("         Date     Day (Sol)   Tmax, C     Tmin, C      Pressure, Pa");

        for(int i = 0; i < nWeatherData; ++i) {
            dailyWeatherData[i].print();
        }
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
