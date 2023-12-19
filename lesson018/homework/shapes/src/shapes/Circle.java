package shapes;

public class Circle extends Shape {
    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public String getTitle() { return "Circle"; }
    @Override
    public double getArea() { return Math.PI * radius * radius; }
    @Override
    public double getPerimeter() { return 2.0 * Math.PI * radius; }
    @Override
    public void print() {
        System.out.println(getTitle() + "\n"
                    + "  - radius: " + radius);
    }
}
