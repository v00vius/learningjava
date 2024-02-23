import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvgCalcTest {

static double[] testNumbers = {0, 1, 2, 3, 3, 2, 1, 0};

@Test
void getAverage()
{
        var experted = 1.5;
        var got = AvgCalc.getAverage(testNumbers);

        assertEquals(experted, got, 1e-4);
}

@Test
void getMax()
{
        var experted = 3.;
        var got = AvgCalc.getMax(testNumbers);

        assertEquals(experted, got, 1e-4);
}
}