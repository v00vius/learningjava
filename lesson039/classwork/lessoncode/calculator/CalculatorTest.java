package calculator;

public class CalculatorTest {
    public static void main(String[] args) {
        CalculatorUtil util = new CalculatorUtil();

        double sourceData = 20;
        double expectedResult = 400;
        double actualResult = util.calculateSquareArea(sourceData);


        if (expectedResult == actualResult) {
            System.out.println("Test # 1.  Ok!");
        } else {
            System.out.println("Test # 1.  FAIL!");
            System.out.println("Expected " + expectedResult + ", but received " + actualResult );
        }


    }
}
