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
    public Book getBook(int shelf, int index) {
        return books[bookIndex(shelf, index)];
    }
    // добавить книгу book в шкаф
    public boolean insertBook(Book book) {
        for (int i = 0; i < getNumberOfShelves(); ++i) {
            if(insertBook(i, book))
                return true;
        }

        return false;
    }
    // добавить книгу book на полку shelf
    public boolean insertBook(int shelf, Book book) {
        for (int i = 0; i < getBooksPerShelf(); ++i) {
            if(insertBook(shelf, i, book))
                return true;
        }

        return false;
    }
    // удалить книгу book из шкафа
    public boolean removeBook(Book book) {
        for (int i = 0; i < getNumberOfShelves(); ++i) {
            if(removeBook(i, book))
                return true;
        }

        return false;
    }
    // удалить книгу book c полки shelf
    public boolean removeBook(int shelf, Book book) {
        for (int i = 0; i < getBooksPerShelf(); ++i) {
            if(removeBook(shelf, i, book))
                return true;
        }

        return false;

    }
    // переместить книгу book с одной полки на полку shelf
    public boolean moveBook(int shelf, Book book) {
        int freeSlot = getFreeSlot(shelf);

        if(-1 == freeSlot)
            return false;

        if(!removeBook(book))
            return false;

        return insertBook(shelf, freeSlot, book);
    }
    // поменять две книги местами
    public boolean swapBooks(Book book1, Book book2) {
        if(book1 == book2)
            return true;

        int index1 = findBookIndex(book1);
        int index2 = findBookIndex(book2);

        if(index1 == -1 || index2 == -1) 
            return false;

        books[index1] = book2;
        books[index2] = book1;

        return true;
    }        
    // удалить книгу book c полки shelf с позиции index
    private boolean removeBook(int shelf, int index, Book book) { 
        if(book.equals(getBook(shelf, index))) {
            books[bookIndex(shelf, index)] = emptyBook;
            incrementRemovalCount();

            return true;
        }

        return false;
    }

    private boolean isEmpty(int shelf, int index) {
        return emptyBook.equals(getBook(shelf, index));
    }

    private int getFreeSlot(int shelf) {
        for (int i = 0; i < getBooksPerShelf(); ++i) {
            if(isEmpty(shelf, i))
                return i;
        }

        return -1;
    }
    private int bookIndex(int shelf, int index) {
        return shelf * booksPerShelf + index;
    }
    private boolean insertBook(int shelf, int index, Book book) {
        if(!isEmpty(shelf, index))
            return false;

        books[bookIndex(shelf, index)] = book;
        incrementInsertionCount();

        return true;
    }
    private int findBookIndex(Book book) {
        for (int i = 0; i < books.length; ++i) {
            if(book.equals(books[i]))
                return i;
        }

        return -1;
    }   
}
