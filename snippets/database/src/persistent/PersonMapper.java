package persistent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper extends Mapper<Person> {
@Override
public Person map(ResultSet rs) throws SQLException
{
        var  person = new Person();

        person.setName(rs.getString("name"));
        person.setLast_name(rs.getString("last_name"));
        person.setAge(rs.getInt("age"));

        return person;
}

@Override
public void map(Person entity, PreparedStatement statement) throws SQLException
{
        statement.setString(1, entity.getName());
        statement.setString(2, entity.getLast_name());
        statement.setInt(3, entity.getAge());
}
}
