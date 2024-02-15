package persistent;

import javax.crypto.spec.PBEKeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class App {
static private Connection connection;

public static void main(String[] args) throws SQLException
{
        var aRow = new PersonMapper();
        var random = new Random(System.currentTimeMillis());
        PreparedStatement st = null;

        try {
                connection = initDatabaseConnection();

                var rows = connection.prepareStatement("SELECT * FROM person LIMIT 10").executeQuery();
                List<Person> people = aRow.load(rows);

                System.out.println(people);

                var insert = new Query();

                st = insert.prepareStatement(connection, """
                        INSERT INTO person (name, last_name, age, occupation)
                        VALUES ({name}, {last_name}, {age}, {occupation})
                        """
                );

                var  count = 0;

                for (int k = 0; k < 1000; k++) {
                        people = IntStream.range(1, 1_000)
                                .mapToObj(i ->
                                {
                                        var person = new Person();

                                        person.setName(i + " - Name - " + random.nextInt(1000));
                                        person.setLastName(i + " - LastName - " + random.nextInt(1000));
                                        person.setAge(random.nextInt(18, 80));
                                        person.setOccupation(i + "- Occupation - " + random.nextInt(1000));

                                        return person;
                                })
                                .toList();

                        aRow.store(people, insert);
                        connection.commit();
                        count += people.size();
                        System.out.println(count + " persons inserted");
                }
        } catch (SQLException e) {
                System.out.println("# Error: " + e.getMessage());
        } finally {
                if(st != null) st.close();
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
