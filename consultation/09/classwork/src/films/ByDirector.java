package films;

import java.util.Comparator;

public class ByDirector implements Comparator<Film> {
@Override
public int compare(Film o1, Film o2)
{
        return o1.getDirector().compareTo(o2.getDirector());
}
}
