package service;

import types.Book;
import types.BookCase;

public class Printer {
        public Printer printShelves(BookCase bookCase)
        {
                for (int i = 0; i < bookCase.getNumberOfShelves(); ++i) {
                        System.out.println("[Shelf " + i + "]");

                        for (int j = 0; j < bookCase.getBooksPerShelf(); ++j) {
                                if (bookCase.isEmpty(i, j)) {
                                        continue;
                                }

                                Book book = bookCase.getBookAt(i, j);

                                System.out.print("  " + j + " - ");
                                print(book);
                                System.out.println("");
                        }

                        System.out.println("");
                }

                System.out.println("Total number of books: " + bookCase.getCounts());
                System.out.println("Max number of books on a shelf: " + bookCase.getBooksPerShelf());
                System.out.println("Books set on a shelf: " + bookCase.getInsertions());
                System.out.println("Books took off a shelf: " + bookCase.getRemovals());
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

                return this;
        }


        public Printer print(Book book)
        {
                System.out.print("'" + book.getTitle() + "' by " + book.getAuthor());

                return this;
        }
}
