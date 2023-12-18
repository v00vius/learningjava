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
    @Override
    public String getTitle() { return "Triangle"; }
    @Override
    public double getArea() {
        double s = (sideA + sideB + sideC) / 2.0;

        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }
    @Override
    public void print() {
        System.out.println(getTitle() + "\n"
                    + "  - sideA: " + sideA + "\n"
                    + "  - sideB: " + sideB + "\n"
                    + "  - sideC: " + sideC);
    }
}
