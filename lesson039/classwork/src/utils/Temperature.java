package utils;

public class Temperature {
static public double toCelsius(double f)
{
        return 5. / 9. * (f - 32.);
}
static public double toFahrenheit(double c)
{
        return c * 9. / 5. + 32.;
}
}
