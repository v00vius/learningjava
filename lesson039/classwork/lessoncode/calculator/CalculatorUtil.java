package calculator;

public class CalculatorUtil {
    public double calculateSquareArea(double side){
        return Math.pow(side,2);
    }

    public double calculateRectangleArea(double sideA, double sideB){
        return sideA * sideB;
    }

    public double calculateCircleArea(double radius){
        return Math.PI * radius * radius;
    }


}
