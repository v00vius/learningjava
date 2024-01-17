package calculator2;

public class CalculatorNewModel {

        public int sum(int x, int y)
        {
                int result = x + y;
                return result;
        }

        public int sub(int x, int y)
        {
                int result = x - y;
                return result;
        }

        public int mul(int x, int y)
        {
                return x * y;
        }

        public double div(int x, int y)
        {
                return (double) x / y;
        }
}
