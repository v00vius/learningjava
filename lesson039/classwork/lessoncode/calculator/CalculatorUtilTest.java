package calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorUtilTest {

    CalculatorUtil util = new CalculatorUtil();

    int x = 5;
    int y;


    @Test
    public void calculateSquareAreaTest() {

        double expectedResult = 25;
        double actualResult = util.calculateSquareArea(x);
        assertEquals("Тест на площадь квадрата должна быть 25", expectedResult, actualResult,2);
    }

    @Test
    public void calculateRectangleAreaTest() {
        y = 7;
        double expectedResult = 35;
        double actualResult = util.calculateRectangleArea(x,y);
        assertEquals(expectedResult, actualResult,0.01);
    }

    @Test
    public void calculateCircleAreaTest() {
        double expectedResult = 78.5398;
        double actualResult = util.calculateCircleArea(x);

        assertEquals(expectedResult, actualResult,0.001);
    }
}