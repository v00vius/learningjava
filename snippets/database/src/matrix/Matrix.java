package matrix;

import java.sql.SQLException;

public interface Matrix {

        double get(int i, int j) throws SQLException;
        void set(int i, int j, double value) throws SQLException;
        void set(double value) throws SQLException;
        void inc(int i, int j, double amount);
        void mul(int i, int j, double amount);
}
