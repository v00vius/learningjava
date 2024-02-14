package persistent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class App {
static private Connection connection;

public static void main(String[] args) throws SQLException
{
        var person = new Person("Joe", "Peterson", 35, "Developer");

        var pm = new PersonMapper();

        try {
                connection = initDatabaseConnection();

                var rows = connection.prepareStatement("SELECT * FROM person").executeQuery();
                List<Person> people = pm.load(rows);

                System.out.println(people);

        } catch (SQLException e) {
                System.out.println("# Error: " + e.getMessage());
        } finally {
                closeDatabaseConnection(connection);
        }
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
}
