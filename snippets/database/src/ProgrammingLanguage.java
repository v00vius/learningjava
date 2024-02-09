import java.sql.SQLException;

/**
 * CREATE TABLE programming_language(
 *     pl_name VARCHAR(50) NOT NULL UNIQUE,
 *     pl_rating INT
 * );
 */

public class ProgrammingLanguage {
private int id;
private String name;
private int rating;

public ProgrammingLanguage(int id, String name, int rating)
{
        this.id = id;
        this.name = name;
        this.rating = rating;
}

public int getId()
{
        return id;
}

public String getName()
{
        return name;
}

public int getRating()
{
        return rating;
}

@Override
public String toString()
{
        return "ProgrammingLanguage: " +
               "id=" + id +
               ", name='" + name + '\'' +
               ", rating=" + rating +
               '\n';
}
}
