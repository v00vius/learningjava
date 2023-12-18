package shapes;

public class Circle extends Shape {
    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    public String getTitle() { return "Circle"; }
    public double getArea() { return Math.PI * radius * radius; }
    public double getPerimeter() { return 2.0 * Math.PI * radius; }
    public void print() {
        System.out.println(getTitle() + "\n"
                    + "  - radius: " + radius);
    }
}
