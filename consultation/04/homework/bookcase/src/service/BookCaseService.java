package service;

import entity.Book;
import entity.BookCase;

public class BookCaseService {
    public BookCase createBookCase(int numberOfShelves, int booksPerShelf) {
        return new BookCase(numberOfShelves, booksPerShelf);
    }

    public boolean setBook(BookCase bookCase, Book book) {
        return bookCase.setBook(book);
    }
    public boolean setBookOnShelf(BookCase bookCase, int shelf, Book book) {
        return bookCase.setBookOnShelf(shelf, book);
    }
    public boolean takeBook(BookCase bookCase, Book book) {
        return bookCase.takeBook(book);
    }
    public boolean takeBookOffShelf(BookCase bookCase, int shelf, Book book) {
        return bookCase.takeBookOffShelf(shelf, book);
    }
    public boolean moveBookToShelf(BookCase bookCase, int shelf, Book book) {
        return bookCase.moveBookToShelf(shelf, book);
    }
    public boolean swapBooks(BookCase bookCase, Book book1, Book book2) {
        return bookCase.swapBooks(book1, book2);
    }
}
