package shapes;

public class Line extends Shape {
    private double length;

    public Line(double length) {
        this.length = length;
    }
    public String getTitle() { return "Line"; }
    public double getArea() { return 0.0; }
    public double getPerimeter() { return length; }
    public void print() {
        System.out.println("Shape: " + getTitle() + "\n"
                    + "  - length: " + length + "\n");
    }
}
