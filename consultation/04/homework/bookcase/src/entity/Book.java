package entity;

public class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) { 
        this.id = id; 
        this.title = title; 
        this.author = author; 
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + "]";
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
   
}
