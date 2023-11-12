package task4;

/*
Curiosity Rover Daily Mars Weather Report
0 - Date
1 - Sol
2 - Air Temperature (°F), min
3 - Air Temperature (°F), max
4 - Pressure (Pa)
5 - Sunrise (unused)
6 - Sunset (unused)
          0;  1;  2;   3;  4;   5;   6
Nov. 1, 2023;3995;10;-103;695;05:34;17:24
*/

public class DailyWeather {
    public DailyWeather(String date, int dayNumber, int tempMax, int tempMin, int airPressure) {
        this.date = date;                   // a data of the measurement
        this.dayNumber = dayNumber;         // the day since the firs measurement
        this.tempMin = tempMin;             // in Celsius
        this.tempMax = tempMax;             // in Celsius
        this.airPressure = airPressure;     // in Pascals
    }
    public void print() {
        System.out.printf("%15s %10d %10d %10d %15d\n", date, dayNumber, tempMax, tempMin, airPressure);
    }
//  protected:
    protected String date;
    protected int dayNumber;
    protected int tempMin;
    protected int tempMax;
    protected int airPressure;
}

