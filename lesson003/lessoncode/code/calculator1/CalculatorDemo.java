package calculator1;

public class CalculatorDemo {
        public static void main(String[] args)
        {
                // создадим НОВЫЙ объект типа calculator1.Calculator для того, чтобы мы могли
                // сохранить значения в переменных этого объекта и пользоваться его методами
                Calculator calc = new Calculator();

                // сохраним в переменных какие-нибудь значения
                calc.x = 10;
                calc.y = 5;

                // вызовем у объекта Calc метод printSum()
                calc.printSum();

                Calculator calc2 = new Calculator();
                calc2.x = 50;
                calc2.y = 10;

                calc2.printSum();

        }
}
