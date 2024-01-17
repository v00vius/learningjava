package service;

import types.Book;
import types.BookCase;

public class BookCaseService {
        public BookCase createBookCase(int numberOfShelves, int booksPerShelf)
        {
                return new BookCase(numberOfShelves, booksPerShelf);
        }

        public boolean setBook(BookCase bookCase, Book book)
        {
                return bookCase.setBook(book);
        }

        public boolean setBookOnShelf(BookCase bookCase, int shelf, Book book)
        {
                return bookCase.setBookOnShelf(shelf, book);
        }

        public boolean takeBook(BookCase bookCase, Book book)
        {
                return bookCase.takeBook(book);
        }

        public boolean takeBookOffShelf(BookCase bookCase, int shelf, Book book)
        {
                return bookCase.takeBookOffShelf(shelf, book);
        }

        public boolean moveBookToShelf(BookCase bookCase, int shelf, Book book)
        {
                return bookCase.moveBookToShelf(shelf, book);
        }

        public boolean swapBooks(BookCase bookCase, Book book1, Book book2)
        {
                return bookCase.swapBooks(book1, book2);
        }

        public Book getBookAt(BookCase bookCase, int shelf, int index)
        {
                return bookCase.getBookAt(shelf, index);
        }

        public String[] getBookList(BookCase bookCase)
        {
                int counter = 0;
                String[] bookList = new String[bookCase.getCounts()];

                for (int i = 0; i < bookCase.getNumberOfShelves(); ++i) {

                        for (int j = 0; j < bookCase.getBooksPerShelf(); ++j) {
                                if (bookCase.isEmpty(i, j)) {
                                        continue;
                                }

                                Book book = bookCase.getBookAt(i, j);

                                bookList[counter++] = "'" + book.getTitle() + "' by "
                                                      + book.getAuthor();
                        }
                }

                return bookList;
        }
}
