public class WeatherData {
private int temperature;
private String description;

public WeatherData(int temperature, String description)
{
        this.temperature = temperature;
        this.description = description;
}

public int getTemperature()
{
        return temperature;
}

public String getDescription()
{
        return description;
}

@Override
public String toString()
{
        return "WeatherData{" +
                "temperature=" + temperature +
                ", description='" + description + '\'' +
                '}';
}
}
