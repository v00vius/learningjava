package programming;

import java.util.Random;

public class Quadrant {
    private Point point;

    public Quadrant(Point pt) {
        point = new Point();
        pt.copyTo(point);
    }
    public int getQuadrant() {
        byte bx = point.getx() >= 0 ? (byte)1 : 0;
        byte by = point.gety() >= 0 ? (byte)1 : 0;
        int qID = 0;

/* Quadrant numbers are:
    2|1
    -+-
    3|4
 */
        switch ((by << 1) | bx) {
            case 0: qID = 3; break;
            case 1: qID = 4; break;
            case 2: qID = 2; break;
            case 3: qID = 1;
        }

        return qID;
    }

    public Point getPoint() {
        return point;
    }

    public static void main(String[] args) {
        Random rnd = new Random();

        Quadrant q1 = new Quadrant(new Point(10 - rnd.nextInt(21), 10 - rnd.nextInt(21)));
        Quadrant q2 = new Quadrant(new Point(10 - rnd.nextInt(21), 10 - rnd.nextInt(21)));
        Quadrant q3 = new Quadrant(new Point(10 - rnd.nextInt(21), 10 - rnd.nextInt(21)));
        Quadrant q4 = new Quadrant(new Point(10 - rnd.nextInt(21), 10 - rnd.nextInt(21)));

        System.out.println(q1.getPoint() + ", quadrant: " + q1.getQuadrant());
        System.out.println(q2.getPoint() + ", quadrant: " + q2.getQuadrant());
        System.out.println(q3.getPoint() + ", quadrant: " + q3.getQuadrant());
        System.out.println(q4.getPoint() + ", quadrant: " + q4.getQuadrant());
    }
}
