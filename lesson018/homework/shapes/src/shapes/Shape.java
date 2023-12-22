package shapes;

abstract
public class Shape implements ShapeFactory {
    abstract
    public String getTitle();

    abstract
    public double getArea();

    abstract
    public double getPerimeter();

    abstract
    public void print();
}
