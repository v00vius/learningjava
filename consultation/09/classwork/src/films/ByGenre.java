package films;

import java.util.Comparator;

public class ByGenre implements Comparator<Film> {
@Override
public int compare(Film o1, Film o2)
{
        return o1.getGenre().compareTo(o2.getGenre());
}
}
