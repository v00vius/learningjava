package shapes;

public class Rectangle extends Square {
    private double length;

    public Rectangle(double height, double length) {
        super(height);
        this.length = length;
    }

    public String getTitle() { return "Rectangle"; }
    public double getArea() { return height * length; }
    public double getPerimeter() { return 2 * (height + length); }
}
