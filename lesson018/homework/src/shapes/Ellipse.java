package shapes;

public class Ellipse extends Circle {
    private double radius2;

    public Ellipse(double radius, double radius2) {
        super(radius);
        this.radius2 = radius2;
    }
    @Override
    public String getTitle() { return "Ellipse"; }
    @Override
    public double getArea() { return Math.PI * radius * radius2; }
    // The perimeter is an approximation
    @Override
    public double getPerimeter() {
        double h = Math.pow(radius2 - radius, 2.0) / Math.pow(radius2 + radius, 2.0);

        return Math.PI * (radius2 + radius) 
                * (1.0 + 3.0 * h / (10.0 + Math.pow(4.0 - 3.0 * h, 0.5)));
    }

    @Override
    public void print() {
        System.out.println(getTitle() + "\n"
                    + "  - radius1: " + radius + "\n"
                    + "  - radius2: " + radius2);
    }
}
