package persistent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper extends Mapper<Person> {
@Override
public Person map(ResultSet rs) throws SQLException
{
        var  p = new Person();

        p.setName(rs.getString("name"));
        p.setLast_name(rs.getString("last_name"));
        p.setAge(rs.getInt("age"));

        return p;
}
}
