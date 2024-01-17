package service;

import types.*;

public class BookCaseService {

        public Bookcase createBookCase(int totalNumberOfShelves)
        {
                Bookcase newBookCase = new Bookcase(totalNumberOfShelves);
                return newBookCase;
        }

        public boolean putBookOnTheShelf(Book book, int numberOfShelf, Bookcase bookcase)
        {
                Bookshelf[] bookshelves = bookcase.getBookshelves();
                Bookshelf ourTargetShelf = bookshelves[numberOfShelf];
                Book[] booksOnTheShelf = ourTargetShelf.getBooks();

                Integer freePlace = findFreePlaceOnTheShelf(booksOnTheShelf);

                if (freePlace >= 0) {
                        booksOnTheShelf[freePlace] = book;
                        return true;
                } else {
                        System.out.println("На полке нет свободного места для книги");
                        return false;
                }
        }

        private Integer findFreePlaceOnTheShelf(Book[] booksOnTheShelf)
        {
                Integer quantityBooksOnTheShelf = booksOnTheShelf.length;
                for (int i = 0; i < quantityBooksOnTheShelf; i++) {
                        if (booksOnTheShelf[i] == null) {
                                return i;
                        }
                }
                return -1;
        }
}
