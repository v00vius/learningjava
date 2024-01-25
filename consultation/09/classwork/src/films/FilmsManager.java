package films;

import java.util.LinkedList;
import java.util.List;

public class FilmsManager {
private List<Film> films;

public FilmsManager()
{
        films = new LinkedList<>();
}

public Film insert(String title, String genre, String director)
{
        Film film = new Film(title, genre, director);

        films.add(film);

        return film;
}

public List<Film> getFilms()
{
        return films;
}
}
