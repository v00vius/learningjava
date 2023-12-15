package entity;

import utils.Counter;

public class BookCase extends Counter {
    private int numberOfShelves;
    private int booksPerShelf;
    private Book[] books;

    public BookCase(int numberOfShelves, int booksPerShelf) {
        super();

        this.numberOfShelves = numberOfShelves; 
        this.booksPerShelf = booksPerShelf;

        books = new Book[numberOfShelves * booksPerShelf];
    }

    public int getNumberOfShelves() {
        return numberOfShelves;
    }
    public int getBooksPerShelf() {
        return booksPerShelf;
    }
    public int bookIndex(int shelf) {
        return bookIndex(shelf, 0);
    }
    public int bookIndex(int shelf, int index) {
        return shelf * booksPerShelf + index;
    }
    public Book getBook(int shelf, int index) {
        return books[bookIndex(shelf, index)];
    }
    public boolean isEmpty(int shelf, int index) {
        return books[bookIndex(shelf, index)] == null;
    }
    public boolean insertBook(int shelf, int index, Book book) {
        if(!isEmpty(shelf, index))
            return false;

        books[bookIndex(shelf, index)] = book;
        incrementInsertionCount();

        return true;
    }
    public Book removeBook(int shelf, int index) { 
        Book book = books[bookIndex(shelf, index)];

        books[bookIndex(shelf, index)] = null;

        if(book != null)
            incrementRemovalCount();

        return book;
    }
}
