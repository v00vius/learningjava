package persistent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App {
static private Connection connection;

public static void main(String[] args)
{
        var person = new Person("Joe", "Peterson", 35, "Developer");

        try {
                connection = initDatabaseConnection();
                var objMap = connection.getTypeMap();

                objMap.put("person", Class.forName("Person"));
                connection.setTypeMap(objMap);

                var st = connection.prepareStatement("SELECT * FROM person");

                var rows = st.executeQuery();

                if(rows.next()) {
                        rows.getObject();
                }

        } catch (SQLException e) {
                System.out.println("# Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
                System.out.println("# Error: " + e.getMessage());
                throw new RuntimeException(e);
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
