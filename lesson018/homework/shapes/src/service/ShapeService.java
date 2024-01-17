package service;

import java.util.Random;

import shapes.*;

public class ShapeService {
        private Shape nullShape;
        private Random random;

        public ShapeService()
        {
                this.nullShape = new Line(0.0);
                random = new Random();
        }

        public Shape shapeFactory(int shapeType, double areaSize)
        {
                switch (shapeType) {
                case 1:
                        return new Line(random.nextDouble(areaSize));

                case 2:
                        return new Square(random.nextDouble(areaSize));

                case 3:
                        return new Rectangle(random.nextDouble(areaSize), random.nextDouble(areaSize));

                case 4:
                        return new Circle(random.nextDouble(areaSize));

                case 5:
                        return new Ellipse(random.nextDouble(areaSize), random.nextDouble(areaSize));

                case 6: {
                        double sideA = random.nextDouble(areaSize);
                        double sideB = random.nextDouble(areaSize);
                        double sideC = Math.max(sideA, sideB) +
                                       Math.min(sideA, sideB) / 2.0;

                        return new Triangle(sideA, sideB, sideC);

                }

                default:
                        return nullShape;
                }
        }

        public Shape getNullShape()
        {
                return nullShape;
        }

        public Shape[] createShapes(int numberOfShapes, double areaSize)
        {
                Shape[] shapes = new Shape[numberOfShapes];

                for (int i = 0; i < numberOfShapes; ++i) {
                        shapes[i] = shapeFactory(1 + random.nextInt(6), areaSize);
                }

                return shapes;
        }

        public Shape[] createShapes2(int numberOfShapes, double areaSize)
        {
                Shape[] shapes = new Shape[numberOfShapes];
                Shape[] factory = {
                        new Line(),
                        new Square(),
                        new Rectangle(),
                        new Circle(),
                        new Ellipse(),
                        new Triangle()
                };

                for (int i = 0; i < numberOfShapes; ++i) {
                        shapes[i] = factory[random.nextInt(factory.length)].factory(areaSize);
                }

                return shapes;
        }
}

