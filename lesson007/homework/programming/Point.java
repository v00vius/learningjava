package programming;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {}

    public Point copyTo(Point dst) {
        dst.x = x;
        dst.y = y;

        return dst;
    }
    public int getx() { return x; }
    public int gety() { return y; }

    @Override
    public String toString() {
        return "{x=" + x + ", y=" + y + "}";
    }

}
