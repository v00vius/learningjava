package entity;

import java.util.Arrays;

public class Bookshelf {
    private Integer id;
    private Book[] books;

    public Bookshelf(Integer id, Book[] books) {
        this.id = id;
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }

    public void printBookshelf(){
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getBookAuthor() + ", " + books[i].getBookName());
        }
    }

    @Override
    public String toString() {
        return "Bookshelf{" +
                "books=" + Arrays.toString(books) +
                '}';
    }
}
