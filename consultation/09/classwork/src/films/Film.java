package films;

public class Film {
private final String title;
private final String genre;
private final String director;

public Film(String title, String genre, String director)
{
        this.title = title;
        this.genre = genre;
        this.director = director;
}

public String getTitle()
{
        return title;
}

public String getGenre()
{
        return genre;
}

public String getDirector()
{
        return director;
}

@Override
public String toString()
{
        return "Film{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                '}';
}
}
