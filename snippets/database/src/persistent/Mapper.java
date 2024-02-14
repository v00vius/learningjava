package persistent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class Mapper<T> {
public List<T> load(ResultSet rs) throws SQLException
{
        List<T> list = new ArrayList<>();

        while (rs.next()) {
                list.add(map(rs));
        }

        return list;
}
public abstract T map(ResultSet rs) throws SQLException;
}
