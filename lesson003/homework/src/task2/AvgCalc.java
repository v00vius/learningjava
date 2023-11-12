package task2;

public class AvgCalc {
    int a0 = 0, a1 = 1, a2 = 2, a3 = 3, a4 = 4,
            a5 = 5, a6 = 6, a7 = 7, a8 = 8, a9 = 9;

    int avg;
    int rem;

    public int calcAvg() {
        avg = a0 + a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8 + a9;
        rem = avg % 10;

        return avg /= 10;
    }

    public void print() {
        System.out.printf("average: %d\nremaining: %d", avg, rem);
    }
}
