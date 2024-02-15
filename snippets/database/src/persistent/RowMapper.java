package persistent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class RowMapper<T> {
public List<T> load(ResultSet rs) throws SQLException
{
        List<T> entities = new ArrayList<>();

        while (rs.next())
                entities.add(map(rs));

        return entities;
}
public Optional<T> loadEntity(ResultSet rs) throws SQLException
{
        if (rs.next())
                return Optional.of(map(rs));

        return Optional.empty();
}

public void store(List<T> entities, Query q) throws SQLException
{
        for (T e : entities)
                store(e, q);
}
public void store(T entity, Query q) throws SQLException
{
        map(entity, q);
        q.getStatement().executeUpdate();
}
public abstract T map(ResultSet rs) throws SQLException;
public abstract void map(T entity, Query q) throws SQLException;
}
