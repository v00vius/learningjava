package matrix;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBMatrix implements Matrix {
private Connection connection;
private String name;
private int rows;
private int cols;

public DBMatrix(Connection connection, String name, int rows, int cols)
{
        this.connection = connection;
        this.name = name;
        this.rows = rows;
        this.cols = cols;
}

public void init()
{
        createSequence();
        createMatrix();
        initMatrix();
}
private void createSequence()
{
        var sql = "CREATE SEQUENCE sq_" + name + " INCREMENT=1 START=0 CACHE=1000 NOCYCLE";

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
public double get(int i, int j)
{
        var row_id = i * cols + j;
        var sql = "SELECT value FROM mt_" + name  + " WHERE row_id=" + row_id;
        var value = 0.;

        try(
                var st = connection.prepareStatement(sql);
                var result = st.executeQuery()
        ) {
                if(result.next()) {
                        value = result.getDouble(1);
                }
        } catch (SQLException e) {
                System.out.println(e.getMessage());
        }

        return value;
}

@Override
public void set(int i, int j, double value)
{
        var row_id = i * cols + j;
        var sql = "UPDATE mt_" + name + " SET value = " + value + " WHERE row_id=" + row_id;

        try(var st = connection.prepareStatement(sql)) {
                var rowsUpdated  = st.executeUpdate();
        } catch (SQLException e) {
                System.out.println(e.getMessage());
        }
}

@Override
public void set(double value)
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
}
