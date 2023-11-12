package Tesk5;

public class Remainder {
    int div;
    int nMax;

    public Remainder(int div, int nMax) {
        this.div = div;
        this.nMax = nMax;
    }

    public void doAll() {
        for(int i = 0; i < nMax; ++i) {
            int rem = i % div;

            System.out.printf("%d = %d %% %d\n", rem, i, div);
        }

        System.out.println("");
    }
}
