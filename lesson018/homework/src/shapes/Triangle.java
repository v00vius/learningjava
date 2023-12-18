package shapes;

public class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    public String getTitle() { return "Triangle"; }
    public double getArea() {
        double s = (sideA + sideB + sideC) / 2.0;

        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }
    public void print() {
        System.out.println("Shape: " + getTitle() + "\n"
                    + "  - sideA: " + sideA + "\n"
                    + "  - sideB: " + sideB + "\n"
                    + "  - sideC: " + sideC);
    }
}
