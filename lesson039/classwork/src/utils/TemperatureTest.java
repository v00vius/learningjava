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
}
}