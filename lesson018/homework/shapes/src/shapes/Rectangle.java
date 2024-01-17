package shapes;

import java.util.Random;

public class Rectangle extends Square {
        private double length;

        public Rectangle(double height, double length)
        {
                super(height);
                this.length = length;
        }

        public Rectangle()
        {
        }

        @Override
        public String getTitle()
        {
                return "Rectangle";
        }

        @Override
        public double getArea()
        {
                return height * length;
        }

        @Override
        public double getPerimeter()
        {
                return 2.0 * (height + length);
        }

        @Override
        public void print()
        {
                System.out.println(getTitle() + "\n"
                                   + "  - height: " + height + "\n"
                                   + "  - length: " + length);
        }

        @Override
        public Shape factory(double areaSize)
        {
                Random random = new Random();

                return new Rectangle(random.nextDouble(areaSize), random.nextDouble(areaSize));
        }

}
