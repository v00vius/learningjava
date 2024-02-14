package matrix;

import java.sql.*;
import java.util.Random;

public class DBMatrix implements Matrix {
private Connection connection;
private String name;
private int rows;
private int cols;
private PreparedStatement stUpdate;
private PreparedStatement stSelect;

public DBMatrix(Connection connection, String name, int rows, int cols) throws SQLException
{
        this.connection = connection;
        this.name = name;
        this.rows = rows;
        this.cols = cols;

        stUpdate = connection.prepareStatement("UPDATE mt_" + name + " SET value = ? WHERE row_id = ?");
        stSelect = connection.prepareStatement("SELECT value FROM mt_" + name  + " WHERE row_id = ?");
}

public void init()
{
        createSequence();
        createMatrix();
        initMatrix();
}
private void createSequence()
{
        var sql = "CREATE SEQUENCE sq_" + name + " MINVALUE=0 START=0 INCREMENT=1 CACHE=1000 NOCYCLE";

        try (var st = connection.prepareStatement(sql)) {
                int rc = st.executeUpdate();
        } catch (SQLException e) {
                System.out.println(e.getMessage());
        }
}
private void createMatrix()
{
        var sql = "CREATE TABLE mt_" + name  + " ("
                        + "row_id INT NOT NULL DEFAULT (NEXT VALUE FOR sq_" + name +  "),"
                        + "value DOUBLE,"
                        + "PRIMARY KEY(row_id)"
                        + ")";

        try (var st = connection.prepareStatement(sql)) {
                var rc = st.executeUpdate();
        } catch (SQLException e) {
                System.out.println(e.getMessage());
        }
}

private int initMatrix()
{
        var size = rows * cols;
        var rowsInserted = 0;
        var sql = "INSERT INTO mt_" + name  + " (value) VALUES (0.0)";

        try (var st = connection.prepareStatement(sql))
        {
                while(size-- > 0)
                        rowsInserted += st.executeUpdate();

        } catch (SQLException e) {
                System.out.println(e.getMessage());
        }

        return rowsInserted;
}
@Override
public double get(int i, int j) throws SQLException
{
        var value = 0.;

        stSelect.setInt(1, index(i, j));

        var result = stSelect.executeQuery();

        if(result.next()) {
                value = result.getDouble(1);
        }

        result.close();

        return value;
}
private int index(int i, int j)
{
        return i * cols + j;
}

@Override
public void set(int i, int j, double value) throws SQLException
{
        stUpdate.setDouble(1, value);
        stUpdate.setInt(2, index(i, j));

        var rowsUpdated  = stUpdate.executeUpdate();
}

@Override
public void set(double value) throws SQLException
{
        for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                        set(i, j, value);
                }
        }
}

@Override
public void inc(int i, int j, double amount)
{
        var row_id = i * cols + j;
        var sql = "UPDATE mt_" + name + " SET value = value + " + amount + " WHERE row_id=" + row_id;

        try(var st = connection.prepareStatement(sql)) {
                var rowsUpdated  = st.executeUpdate();
        } catch (SQLException e) {
                System.out.println(e.getMessage());
        }
}

@Override
public void mul(int i, int j, double amount)
{
        var row_id = i * cols + j;
        var sql = "UPDATE mt_" + name + " SET value = value * " + amount + " WHERE row_id=" + row_id;

        try(var st = connection.prepareStatement(sql)) {
                var rowsUpdated  = st.executeUpdate();
        } catch (SQLException e) {
                System.out.println(e.getMessage());
        }
}
//---
private static Connection initDatabaseConnection() throws SQLException {
        System.out.println("Connecting to the database...");
        var connection = DriverManager.getConnection(
                "jdbc:mariadb://127.0.0.1:60543/demo",
                "user",
                "123"
        );

        connection.setAutoCommit(false);
        System.out.println("Connection valid: " + connection.isValid(5));

        return connection;
}

private static void closeDatabaseConnection(Connection connection) throws SQLException {
        System.out.println("Closing database connection...");
        connection.close();
        System.out.println("Connection valid: " + connection.isValid(5));
}

public static void main(String[] args) throws SQLException
{
        Connection connection = null;

        try {
                connection = initDatabaseConnection();
                var size = 1_000;
                var matrix = new DBMatrix(connection, "m01", size, size);

//                matrix.init();
//                connection.commit();

//                for (int i = 0; i < size; i++) {
//                        for (int j = 0; j < size; j++) {
//                                matrix.set(i, j, (double) i * size + j);
//                        }
//
//                        connection.commit();
//                }

                Random random = new Random(System.currentTimeMillis());
                long delta = System.currentTimeMillis();

                for (int i = 0, n = 10 * size * size; i < n; ++i) {
                        int x = random.nextInt(size);
                        int y = random.nextInt(size);
                        var tmp = matrix.get(y, x);

                        matrix.set(y, x, matrix.get(x, y));
                        matrix.set(x, y, tmp);

                        if (i % 50_000 == 0) {
                                connection.commit();
                                System.out.println(i);
                        }
                }

                delta = System.currentTimeMillis() - delta;

                System.out.printf("(%d,%d) = %f, %7.2f op/s\n",
                        size-1, size-1, matrix.get(size-1, size-1),
                        (double)size * size * 1000. / delta);

        } catch (SQLException e) {
                System.out.println(e.getMessage());
        } finally {
                closeDatabaseConnection(connection);
        }

}
}
