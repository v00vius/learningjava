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

        System.out.printf("\nMin temperature: %d\n", minTemp );
        System.out.printf("Max temperature: %d\n", maxTemp );
        System.out.printf("Avg temperature, daily: %d\n", avgTempDay );
        System.out.printf("Avg temperature, nightly: %d\n", avgTempNight );
    }
    public void updateStats() {
        minTemp = 500;
        maxTemp = -500;
        avgTempDay = 0;
        avgTempNight = 0;

        for(int i = 0; i < nWeatherData; ++i) {
            if(dailyWeatherData[i].tempMin < minTemp) {
                minTemp = dailyWeatherData[i].tempMin;
            }


            if(dailyWeatherData[i].tempMax > maxTemp)
                maxTemp = dailyWeatherData[i].tempMax;

            avgTempDay += dailyWeatherData[i].tempMax;
            avgTempNight += dailyWeatherData[i].tempMin;
        }

        avgTempDay /= nWeatherData;
        avgTempNight /= nWeatherData;
    }

    public String place() { return place; }
    public void setPlace(String place) { this.place = place; }

    //  protected:
    protected String place;
    protected int nWeatherData;
    protected DailyWeather[] dailyWeatherData;

    protected int minTemp;
    protected int avgTempDay;
    protected int avgTempNight;
    protected int maxTemp;
}
