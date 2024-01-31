import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class WeatherHandler implements Function<WeatherData, String> {
private final Map<String, String> response;

public WeatherHandler()
{
        this.response = new HashMap<>();

        response.put("солнечно", "Не забудьте солнцезащитный крем!");
        response.put("облачно", "Может быть, понадобится зонт.");
        response.put("дождь", "Не забудьте зонт!");
}

@Override
public String apply(WeatherData weatherData)
{
        if(weatherData.getTemperature() < -50 ||
                weatherData.getTemperature() > 50)
                return "Температура не соответствует климатической норме";

        String recommendation = response.get(weatherData.getDescription());

        if(recommendation == null)
                return "Сегодняшняя погода: " + weatherData.getDescription();

        return recommendation;
}
}
