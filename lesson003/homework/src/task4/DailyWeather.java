package task4;

public class DailyWeather {
    public DailyWeather(String date, int dayNumber, int tempMin, int tempMax, int airPressure) {
        this.date = date;
        this.dayNumber = dayNumber;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.airPressure = airPressure;
    }

    //  protected:
    protected String date;
    protected int dayNumber;
    protected int tempMin;
    protected int tempMax;
    protected int airPressure;
}

