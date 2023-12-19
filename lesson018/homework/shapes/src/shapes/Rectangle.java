package shapes;

public class Rectangle extends Square {
    private double length;

    public Rectangle(double height, double length) {
        super(height);
        this.length = length;
    }

    @Override
    public String getTitle() { return "Rectangle"; }
    @Override
    public double getArea() { return height * length; }
    @Override
    public double getPerimeter() { return 2.0 * (height + length); }
    @Override
    public void print() {
        System.out.println(getTitle() + "\n"
                    + "  - height: " + height + "\n"
                    + "  - length: " + length);
    }
}
