public class Test {
public static void main(String[] args)
{
        WeatherData[] weatherData = {
                new WeatherData(-60, "солнечно"),
                new WeatherData(25, "солнечно"),
                new WeatherData(30, "облачно"),
                new WeatherData(0, "дождь"),
                new WeatherData(-10, "снег")
        };

        WeatherHandler  weatherHandler = new WeatherHandler();

        for (WeatherData wd : weatherData) {
                String prompt = weatherHandler.apply(wd);
                System.out.println(wd);
                System.out.println(prompt);
        }
}
}
