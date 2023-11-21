package programming;

// Leap day occurs in each year that is an integer multiple of 4
// (except for years evenly divisible by 100, but not by 400).
public class Year {
    private int year;

    public Year(int year) {
        this.year = year;
    }

    public boolean isLeapYear() {
        return (year %4 == 0 && !(year % 100 == 0 && !(year % 400 == 0) ));
    }
    @Override
    public String toString () {
        return "Year " + year;
    }

    public static void main(String[] args) {
        Year y1 = new Year(1764);
        Year y2 = new Year(2005);
        Year y3 = new Year(2096);
        Year y4 = new Year(2095);

        System.out.println(y1 + (y1.isLeapYear() ? " is the leap year" : " isn't leap year"));
        System.out.println(y2 + (y2.isLeapYear() ? " is the leap year" : " isn't leap year"));
        System.out.println(y3 + (y3.isLeapYear() ? " is the leap year" : " isn't leap year"));
        System.out.println(y4 + (y4.isLeapYear() ? " is tje leap year" : " isn't leap year"));
    }
}
