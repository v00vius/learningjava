package shapes;

import java.util.Random;

public class Square extends Shape {
        protected double height;

        public Square(double height)
        {
                this.height = height;
        }

        public Square()
        {
        }

        @Override
        public String getTitle()
        {
                return "Square";
        }

        @Override
        public double getArea()
        {
                return height * height;
        }

        @Override
        public double getPerimeter()
        {
                return height * 4.0;
        }

        @Override
        public void print()
        {
                System.out.println(getTitle() + "\n"
                                   + "  - height: " + height);
        }

        @Override
        public Shape factory(double areaSize)
        {
                return new Square(new Random().nextDouble(areaSize));
        }
}
