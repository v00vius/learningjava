package matrix;

public interface Matrix {

        double get(int i, int j);
        void set(int i, int j, double value);
        void set(double value);
        void inc(int i, int j, double amount);
        void mul(int i, int j, double amount);
}
