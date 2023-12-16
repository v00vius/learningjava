import service.*;
import shapes.*;

public class App {
    public static void main(String[] args) {
        ShapeService shapeService = new ShapeService();
        Shape[] shapes = shapeService.createShapes(20, 100.0);

        double totalArea = 0.0;
        double totalPerimeter = 0.0;

        for (Shape shape : shapes) {
            shape.print();
            double area = shape.getArea();
            double perimeter = shape.getPerimeter();

            System.out.println("  - area: " + area);
            System.out.println("  - perimeter: " + perimeter + "\n");

            totalArea += area;
            totalPerimeter += perimeter;
        }

        System.out.println("Total area: " + totalArea);
        System.out.println("Total perimeter: " + totalPerimeter);
    }    
}
