import java.util.HashMap;
import java.util.Map;

public class SqlString {
private String sql;
private String sql2;
private Map<String, Integer> indexes;

public SqlString(String sql)
{
        this.sql = sql;
        indexes = new HashMap<>();
}
/*
 * INSERT INTO programming_language(pl_name, pl_rating)
 * VALUES ({pl_name}, {pl_rating})
 *
 */
public String init()
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
        return  sql2 = sb.toString();
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

public static void main(String[] args)
{
        var query = new SqlString("INSERT INTO programming_language(pl_name, pl_rating) VALUES ({pl_name}, {pl_rating})");

        query.init();

        System.out.println(query.getIndexes());
        System.out.println(query.getSql());
        System.out.println(query.getSql2());
        System.out.println(query.getIndex("pl_name"));
        System.out.println(query.getIndex("pl_rating"));
        System.out.println(query.getIndex("eee"));
}
}
