package matrix;

import java.sql.*;
import java.util.Random;

public class Matrix2D implements Matrix {
private Connection connection;
private String name;
private PreparedStatement stSet;
private PreparedStatement stGet;

public Matrix2D(Connection connection, String name) throws SQLException
{
        this.connection = connection;
        this.name = name;

        stSet = connection.prepareCall("CALL matrix_set('" + name + "', ?, ?, ?)");

        stGet = connection.prepareStatement("SELECT value FROM matrix2d WHERE name = '"
                                            + name + "' AND row = ? AND col = ?");
}

@Override
public double get(int i, int j) throws SQLException
{
        stGet.setInt(1, i);
        stGet.setInt(2, j);

        ResultSet rs = stGet.executeQuery();
        var value = 0.;

        if (rs.next())
                value = rs.getDouble(1);

        rs.close();

        return value;
}

@Override
public void set(int i, int j, double value) throws SQLException
{
        stSet.setInt(1, i);
        stSet.setInt(2, j);
        stSet.setDouble(3, value);
        var rc = stSet.executeUpdate();
}

@Override
public void set(double value) throws SQLException
{

}

@Override
public void inc(int i, int j, double amount)
{

}

@Override
public void mul(int i, int j, double amount)
{

}

//---
private static Connection initDatabaseConnection() throws SQLException
{
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

private static void closeDatabaseConnection(Connection connection) throws SQLException
{
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
                var time = 100L * 1000L;
                var matrix = new Matrix2D(connection, "M1");
                Random random = new Random(System.currentTimeMillis());

                if(false) {
                        System.out.println("# Creating a matrix of " + size + "x" + size + " elements");

                        for (int i = 0; i < size; i++) {
                                for (int j = 0; j < size; j++) {
                                        matrix.set(i, j, i * size + j);
                                }

                                connection.commit();
                        }

                        System.out.println("# Done.");
                }

                var count = 0;
                var delta = System.currentTimeMillis();

                if(true) {
                        System.out.println("# Benchmarking ...");

                        while((System.currentTimeMillis() - delta) < time) {
                                int x = random.nextInt(size);
                                int y = random.nextInt(size);
                                var tmp = matrix.get(y, x);

                                tmp *= 1.25;
                                matrix.set(y, x, matrix.get(x, y));
                                matrix.set(x, y, tmp);

                                if (count % 1_000 == 0) {
                                        connection.commit();
                                        System.out.println(4 * count + " IOPS");
                                }

                                ++count;
                        }

                        connection.commit();
                        delta = System.currentTimeMillis() - delta;
                }

                System.out.printf("# Done. %7.2f IOPS\n", (double) count * 4000. / delta);

        } catch (SQLException e) {
                System.out.println(e.getMessage());
        } finally {
                closeDatabaseConnection(connection);
        }

}
}
