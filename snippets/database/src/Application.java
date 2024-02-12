import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;


public class Application {

private static Connection connection;

/**
 * Entry point of the application. Opens and closes the database connection
 * and performs CRUD operations against the database. You need an SQL database
 * with the following table:
 *
 * <pre>
 * CREATE TABLE programming_language(
 *     pl_name VARCHAR(50) NOT NULL UNIQUE,
 *     pl_rating INT
 * );
 * </pre>
 *
 * @param args (not used)
 * @throws SQLException if an error occurs when interacting with the database
 */
public static void main(String[] args) throws SQLException {
        try {
                initDatabaseConnection();
                now();
                getVersion();

                importData(10);
                List<ProgrammingLanguage> languages = readAll();
                System.out.println(languages);

                deleteData("%");
                readData();
                createData("Java", 10);
                createData("JavaScript", 9);
                createData("C++", 8);



                readData();
                updateData("C++", 7);
                readData();
                deleteData("C++");
                readData();
        } finally {
                closeDatabaseConnection();
        }

}

static private List<ProgrammingLanguage> readAll() throws SQLException
{
        List<ProgrammingLanguage> languages = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement("""
				    select * from programming_language
				""")) {
                try (ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                                ProgrammingLanguage pl = new ProgrammingLanguage(resultSet.getInt(1),
                                        resultSet.getString("pl_name"),
                                        resultSet.getInt("pl_rating"));

                                languages.add(pl);
                        }
                }
        }

        return languages;
}

static private Optional<String> now() throws SQLException
{
        try (PreparedStatement statement = connection.prepareStatement("""
				    select now()
				""")) {
                try (ResultSet resultSet = statement.executeQuery()) {
                        System.out.println("Time:");

                        if (resultSet.next()) {
                                String name = resultSet.getString(1);

                                System.out.println("\t> " + name);

                                return Optional.of(name);
                        }
                        else{
                                System.out.println("\t (no data)");

                                return Optional.empty();
                        }
                }
        }

}


static private Optional<String> getVersion() throws SQLException
{
        try (PreparedStatement statement = connection.prepareStatement("""
				    select version()
				""")) {
                try (ResultSet resultSet = statement.executeQuery()) {
                        System.out.println("Version:");

                        if (resultSet.next()) {
                                String name = resultSet.getString(1);

                                System.out.println("\t> " + name);

                                return Optional.of(name);
                        }
                        else{
                                System.out.println("\t (no data)");

                                return Optional.empty();
                        }
                }
        }

}
private static int importData(int n) throws SQLException, IOException
{
        Random random = new Random(System.currentTimeMillis());
        int rowsInserted = 0;
        try (var query = new SqlString(connection, """
				    INSERT INTO programming_language(pl_name, pl_rating)
				    VALUES ({pl_name}, {pl_rating})
				""")) {

                for (int i = 0; i < n; i++) {
                        String name = "Name - " + n + i;
                        int rating = random.nextInt(1, 11);

                        query.set("pl_name", name);
                        query.set("pl_rating", rating);

                        rowsInserted += query.executeUpdate();
                }
        }

        return rowsInserted;
}

private static void createData(String name, int rating) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("""
				    INSERT INTO programming_language(pl_name, pl_rating)
				    VALUES (?, ?)
				""")) {
                statement.setString(1, name);
                statement.setInt(2, rating);
                int rowsInserted = statement.executeUpdate();
                System.out.println("Rows inserted: " + rowsInserted);
        }
}

private static void readData() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("""
				    SELECT pl_name, pl_rating
				    FROM programming_language
				    ORDER BY pl_rating DESC
				""")) {
                try (ResultSet resultSet = statement.executeQuery()) {
                        boolean empty = true;
                        while (resultSet.next()) {
                                empty = false;
                                String name = resultSet.getString("pl_name");
                                int rating = resultSet.getInt("pl_rating");
                                System.out.println("\t> " + name + ": " + rating);
                        }
                        if (empty) {
                                System.out.println("\t (no data)");
                        }
                }
        }
}

private static void updateData(String name, int newRating) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("""
				    UPDATE programming_language
				    SET pl_rating = ?
				    WHERE pl_name = ?
				""")) {
                statement.setInt(1, newRating);
                statement.setString(2, name);
                int rowsUpdated = statement.executeUpdate();
                System.out.println("Rows updated: " + rowsUpdated);
        }
}

private static void deleteData(String nameExpression) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("""
				    DELETE FROM programming_language
				    WHERE pl_name LIKE ?
				""")) {
                statement.setString(1, nameExpression);
                int rowsDeleted = statement.executeUpdate();
                System.out.println("Rows deleted: " + rowsDeleted);
        }
}

private static void initDatabaseConnection() throws SQLException {
        System.out.println("Connecting to the database...");
        connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:60543/demo",
                "user", "password");
        System.out.println("Connection valid: " + connection.isValid(5));
}

private static void closeDatabaseConnection() throws SQLException {
        System.out.println("Closing database connection...");
        connection.close();
        System.out.println("Connection valid: " + connection.isValid(5));
}
}