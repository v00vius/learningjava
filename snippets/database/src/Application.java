

import persistent.Query;

import java.sql.*;
import java.util.*;


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
public static void main(String[] args) throws SQLException
{
        try {
                initDatabaseConnection();
                now();
                getVersion();

                int count = 1_000;
                long delta = System.currentTimeMillis();

                insertData(count);
                delta = System.currentTimeMillis() - delta;

                List<ProgrammingLanguage> languages = readAll();
                System.out.printf("Imported %d records, %5.1f op/s\n", languages.size(),
                        (double)count * 1000. / delta);

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
        } catch (SQLException e) {
                System.out.println(e.getMessage());
        }
        finally {
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
private static int insertData(int n) throws SQLException
{
        Random random = new Random(System.currentTimeMillis());
        int rowsInserted = 0;
        var sql = """
                INSERT INTO programming_language(pl_name, pl_rating)
                VALUES ({pl_name}, {pl_rating})
        """;
        var query = new Query();

        System.out.println(sql);
        System.out.println(query.getSql());
        System.out.println("# Inserting " + n + " rows ...");

        try (var statement = query.prepareStatement(connection, sql)) {
                for (int i = 0; i < n; ++i) {
                        String name = "Name - " + n + i;
                        int rating = random.nextInt(1, 11);

                        query.set("pl_name", name)
                                .set("pl_rating", rating);

                        rowsInserted += statement.executeUpdate();
                }

                connection.commit();
        }

        System.out.println("# " + rowsInserted + " inserted.");
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
                connection.commit();
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
                connection.commit();
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
                connection.commit();
                System.out.println("Rows deleted: " + rowsDeleted);
        }
}

private static void initDatabaseConnection() throws SQLException {
        System.out.println("Connecting to the database...");
        connection = DriverManager.getConnection(
                "jdbc:mariadb://127.0.0.1:60543/demo",
                "user",
                "123"
        );

        connection.setAutoCommit(false);
        System.out.println("Connection valid: " + connection.isValid(5));
}

private static void closeDatabaseConnection() throws SQLException {
        System.out.println("Closing database connection...");
        connection.close();
        System.out.println("Connection valid: " + connection.isValid(5));
}
}