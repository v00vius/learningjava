package shapes;

import java.util.Random;

public class Line extends Shape {
        private double length;

        public Line(double length)
        {
                this.length = length;
        }

        public Line()
        {
        }

        @Override
        public String getTitle()
        {
                return "Line";
        }

        @Override
        public double getArea()
        {
                return 0.0;
        }

        @Override
        public double getPerimeter()
        {
                return length;
        }

        @Override
        public void print()
        {
                System.out.println(getTitle() + "\n"
                                   + "  - length: " + length);
        }

        @Override
        public Shape factory(double areaSize)
        {
                return new Line(new Random().nextDouble(areaSize));
        }

}
