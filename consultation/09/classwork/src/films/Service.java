package films;

import java.util.*;

public class Service {
private FilmsManager films;

public Service(FilmsManager films)
{
        this.films = films;
}

public List<Film> getByGenre()
{
        List<Film> sorted = new ArrayList<>(films.getFilms());

        Collections.sort(sorted, new ByGenre());

        return sorted;
}
public List<Film> getByDirector()
{
        List<Film> sorted = new ArrayList<>(films.getFilms());

        Collections.sort(sorted, new ByDirector());

        return sorted;
}

public List<Film> getIfDirector(String director)
{
        Selection cmp = new CmpDirector(director);
        List<Film> matches = new LinkedList<>();

        for(Film film : films.getFilms()) {
                if(cmp.match(film))
                        matches.add(film);
        }

        return matches;
}

public static void main(String[] args)
{
        FilmsManager filmsManager = new FilmsManager();

        filmsManager.insert("title1", "genre1", "director3");
        filmsManager.insert("title2", "genre1", "director2");
        filmsManager.insert("title3", "genre2", "director2");
        filmsManager.insert("title4", "genre2", "director1");
        filmsManager.insert("title5", "genre3", "director1");

        Service service = new Service(filmsManager);

        List<Film> byDirector = service.getByDirector();

        System.out.println(byDirector);

        List<Film> byGenre = service.getByGenre();

        System.out.println(byGenre);

        List<Film> directors = service.getIfDirector("or2");
        System.out.println(directors);
}
}
