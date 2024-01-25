package films;

public class CmpDirector implements Selection {
private String name;

public CmpDirector(String name)
{
        this.name = name.toLowerCase();
}

@Override
public boolean match(Film film)
{
        return film.getDirector().toLowerCase().contains(name);
}
}
