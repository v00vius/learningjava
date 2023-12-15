package entity;

import utils.Counter;

public class BookCase extends Counter {
    private int numberOfShelves;
    private int booksPerShelf;
    private Book[] books;
    private Book emptyBook;

    public BookCase(int numberOfShelves, int booksPerShelf) {
        super();

        this.numberOfShelves = numberOfShelves; 
        this.booksPerShelf = booksPerShelf;

        books = new Book[numberOfShelves * booksPerShelf];
        emptyBook = new Book(0, "", "");

        for (int i = 0; i < books.length; i++)
            books[i] = emptyBook;     
    }

    public int getNumberOfShelves() {
        return numberOfShelves;
    }
    public int getBooksPerShelf() {
        return booksPerShelf;
    }
    public boolean isFull() {
        return getCounts() == books.length;        
    }
    public boolean isEmpty(int shelf, int index) {
        return emptyBook.equals(books[bookIndex(shelf, index)]);
    }
    private int bookIndex(int shelf, int index) {
        return shelf * booksPerShelf + index;
    }
    public Book getBook(int shelf, int index) {
        return books[bookIndex(shelf, index)];
    }
    public boolean insertBook(Book book) {
        for (int i = 0; i < getNumberOfShelves(); ++i) {
            if(insertBook(i, book))
                return true;
        }

        return false;
    }
    public boolean insertBook(int shelf, Book book) {
        for (int i = 0; i < getBooksPerShelf(); ++i) {
            if(insertBook(shelf, i, book))
                return true;
        }

        return false;
    }

    private boolean insertBook(int shelf, int index, Book book) {
        if(!isEmpty(shelf, index))
            return false;

        books[bookIndex(shelf, index)] = book;
        incrementInsertionCount();

        return true;
    }
    public Book removeBook(int shelf, int index) { 
        Book book = books[bookIndex(shelf, index)];

        books[bookIndex(shelf, index)] = emptyBook;

        if(!book.equals(emptyBook))
            incrementRemovalCount();

        return book;
    }
}
