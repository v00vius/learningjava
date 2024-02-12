import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SqlString implements Closeable {
private Connection connection;
private String sql;
private String sql2;
private Map<String, Integer> indexes;
private PreparedStatement statement;

public SqlString(Connection connection, String sql) throws SQLException
{
        this.connection = connection;
        this.sql = sql;
        indexes = new HashMap<>();
        init();
}

/*
 * INSERT INTO programming_language(pl_name, pl_rating)
 * VALUES ({pl_name}, {pl_rating})
 *
 */
public void init() throws SQLException
{
        int start = 0;
        int idx;
        int parameterIndex = 1;
        StringBuilder sb = new StringBuilder();

        while(-1 != (idx = sql.indexOf('{', start))) {
                int end = sql.indexOf('}', idx + 1);

                if (end == -1)
                        throw new RuntimeException("No } bracket!");

                String aKey = sql.substring(idx + 1, end);

                indexes.put(aKey, parameterIndex);
                sb.append(sql, start, idx)
                        .append('?');

                start = end + 1;
                ++parameterIndex;
        }

        sb.append(sql.substring(start));
        sql2 = sb.toString();
        statement = connection.prepareStatement(sql2);
}
public void set(String parameterName, String x) throws SQLException
{
        statement.setString(getIndex(parameterName), x);
}
public void set(String parameterName, int x) throws SQLException
{
        statement.setInt(getIndex(parameterName), x);
}
public int executeUpdate() throws SQLException
{
        return statement.executeUpdate();
}
public int getIndex(String parameterName)
{
        return indexes.getOrDefault(parameterName, 0);
}
public String getSql()
{
        return sql;
}

public String getSql2()
{
        return sql2;
}

public Map<String, Integer> getIndexes()
{
        return indexes;
}

@Override
public void close() throws IOException
{
        try {
                statement.close();
        } catch (SQLException e) {
                throw new RuntimeException(e);
        }
}
}
