package task5;

import utils.UserInterface;

public class JCalc {
        private double num1;
        private double num2;
        private double sum;
        private double sub;
        private double mul;
        private double div;


        public JCalc(double num1, double num2)
        {
                this.num1 = num1;
                this.num2 = num2;
        }

        public JCalc print()
        {
                System.out.println("I've got the following result(s)");
                System.out.println("  num1 = " + getNum1());
                System.out.println("  num2 = " + getNum2());
                System.out.println("  num1 + num2 = " + sum);
                System.out.println("  num1 - num2 = " + sub);
                System.out.println("  num1 * num2 = " + mul);
                System.out.println("  num1 / num2 = " + div);

                return this;
        }

        public JCalc updateResult()
        {
                sum = num1 + num2;
                sub = num1 - num2;
                mul = num1 * num2;
                div = num1 / num2;

                return this;
        }

        public double getNum1()
        {
                return num1;
        }

        public double getNum2()
        {
                return num2;
        }

        public JCalc setNum1(double num1)
        {
                this.num1 = num1;
                return this;
        }

        public JCalc setNum2(double num2)
        {
                this.num2 = num2;
                return this;
        }

        public static void main(String[] args)
        {

                System.out.println("Hello, I'm a simple math calculator.");
                ;
                System.out.println("I can give you a sum, a subtraction, a multiplication and a division of two numbers.");
                ;

                UserInterface ui = new UserInterface();
                double number1 = ui.getDouble("Enter the first number, please: ");
                double number2 = ui.getDouble("Enter the second number, please: ");

                JCalc calc = new JCalc(number1, number2);

                calc.updateResult().print();
        }
}
