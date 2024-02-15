package persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Query {
private String sql;
private Map<String, Integer> indexes;
private PreparedStatement statement;

public Query() throws SQLException
{
        indexes = new HashMap<>();
}

/*
 * INSERT INTO programming_language(pl_name, pl_rating)
 * VALUES ({pl_name}, {pl_rating})
 *
 */
public PreparedStatement prepareStatement(Connection connection, String format) throws SQLException
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
        statement = connection.prepareStatement(sql);

        return statement;
}
public Query set(String parameterName, String x) throws SQLException
{
        int idx;

        if(0 != (idx = indexOf(parameterName)))
                statement.setString(idx, x);

        return this;
}
public Query set(String parameterName, int x) throws SQLException
{
        int idx;

        if(0 != (idx = indexOf(parameterName)))
                statement.setInt(idx, x);

        return  this;
}
public Query set(String parameterName, double x) throws SQLException
{
        int idx;

        if(0 != (idx = indexOf(parameterName)))
                statement.setDouble(idx, x);

        return  this;
}

public PreparedStatement getStatement()
{
        return statement;
}
public int indexOf(String parameterName)
{
        return indexes.getOrDefault(parameterName, 0);
}
public String getSql()
{
        return sql;
}
}
