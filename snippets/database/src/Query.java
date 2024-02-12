import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Query {
private String format;
private String sql;
private Map<String, Integer> indexes;
private PreparedStatement statement;

public Query(String sql) throws SQLException
{
        this.format = sql;
        indexes = new HashMap<>();
}

/*
 * INSERT INTO programming_language(pl_name, pl_rating)
 * VALUES ({pl_name}, {pl_rating})
 *
 */
public PreparedStatement parse(Connection connection) throws SQLException
{
        int start = 0;
        int idx;
        int parameterIndex = 1;
        StringBuilder sb = new StringBuilder();

        while(-1 != (idx = format.indexOf('{', start))) {
                int end = format.indexOf('}', idx + 1);

                if (end == -1)
                        throw new RuntimeException("No } bracket!");

                String aKey = format.substring(idx + 1, end);

                indexes.put(aKey, parameterIndex);
                sb.append(format, start, idx)
                        .append('?');

                start = end + 1;
                ++parameterIndex;
        }

        sb.append(format.substring(start));
        sql = sb.toString();
        return statement = connection.prepareStatement(sql);
}
public Query set(String parameterName, String x) throws SQLException
{
        statement.setString(indexOf(parameterName), x);

        return this;
}
public Query set(String parameterName, int x) throws SQLException
{
        statement.setInt(indexOf(parameterName), x);

        return  this;
}
public int executeUpdate() throws SQLException
{
        return statement.executeUpdate();
}
public int indexOf(String parameterName)
{
        return indexes.getOrDefault(parameterName, 0);
}
public Map<String, Integer> getIndexes()
{
        return indexes;
}

public String getFormat()
{
        return format;
}

public String getSql()
{
        return sql;
}
}
