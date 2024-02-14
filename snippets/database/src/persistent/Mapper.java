package persistent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Mapper<T> {
public List<T> load(ResultSet rs) throws SQLException
{
        List<T> entities = new ArrayList<>();

        while (rs.next())
                entities.add(map(rs));

        return entities;
}
public Optional<T> loadEntity(ResultSet rs) throws SQLException
{
        T entity;

        if (rs.next())
                Optional.of(map(rs));

        return Optional.empty();
}

public void store(List<T> entities, PreparedStatement st) throws SQLException
{
        for (T e : entities) {
                map(e, st);
                st.executeUpdate();
        }
}
public void store(T entity, PreparedStatement st) throws SQLException
{
        map(entity, st);
        st.executeUpdate();
}
public abstract T map(ResultSet rs) throws SQLException;
public abstract void map(T entity, PreparedStatement statement) throws SQLException;
}
