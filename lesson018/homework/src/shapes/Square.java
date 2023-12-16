package shapes;

public class Square extends Shape {
    protected double height;

    public Square(double height) {
        this.height = height;
    }
    public String getTitle() { return "Square"; }
    public double getArea() { return height * height; }
    public double getPerimeter() { return height * 4; }
}
