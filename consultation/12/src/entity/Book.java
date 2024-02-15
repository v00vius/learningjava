package entity;

public class Book extends LibraryItem implements Describable{

    private String author;
    private String genre;
    private int pages;

    public Book(String title, int year, String author, String genre, int pages) {
        super(title, year);
        this.author = author;
        this.genre = genre;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Override
    public String getDescribe() {
        return "Book: " + getTitle() +  " author: " + author + " genre: " + genre + " pages: " + pages;
    }
}
