package utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class TemperatureTest {

@Test
public void toCelsius()
{
        double expected = -17.77777777777778;
        double actual = Temperature.toCelsius(0.);

        assertEquals(expected, actual, 1e-4);
}

@Test
public void toFahrenheit()
{
        double expected = 32.;
        double actual = Temperature.toFahrenheit(0.);

        assertEquals(expected, actual, 1e-4);
}

@Test
public void toFahrenheit1()
{
        double expected = 212.;
        double actual = Temperature.toFahrenheit(100.);

        assertEquals(expected, actual, 1e-4);
}
@Test
public void toFahrenheit2()
{
        double expected = -148.;
        double actual = Temperature.toFahrenheit(-100.);

        assertEquals(expected, actual, 1e-4);
}
}