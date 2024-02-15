package persistent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper extends RowMapper<Person> {
@Override
public Person map(ResultSet rs) throws SQLException
{
        var  person = new Person();

        person.setId(rs.getInt("id"));
        person.setName(rs.getString("name"));
        person.setLastName(rs.getString("last_name"));
        person.setAge(rs.getInt("age"));
        person.setOccupation(rs.getString("occupation"));

        return person;
}

@Override
public void map(Person entity, Query q) throws SQLException
{
        q.set("id", entity.getId())
                .set("name", entity.getName())
                .set("last_name", entity.getLastName())
                .set("age", entity.getAge())
                .set("occupation", entity.getOccupation());
}
}
