package types;

import utils.Counter;

public class BookCase extends Counter {
        private int numberOfShelves;
        private int booksPerShelf;
        private Book[] books;
        private Book emptyBook;

        public BookCase(int numberOfShelves, int booksPerShelf)
        {
                super();

                this.numberOfShelves = numberOfShelves;
                this.booksPerShelf = booksPerShelf;

                books = new Book[numberOfShelves * booksPerShelf];
                emptyBook = new Book(0, "", "");

                for (int i = 0; i < books.length; ++i)
                        books[i] = emptyBook;
        }

        public int getNumberOfShelves()
        {
                return numberOfShelves;
        }

        public int getBooksPerShelf()
        {
                return booksPerShelf;
        }

        public boolean isFull()
        {
                return getCounts() == books.length;
        }

        public Book getBookAt(int shelf, int index)
        {
                return books[bookIndex(shelf, index)];
        }

        public Book[] getBooks()
        {
                return books;
        }

        private int bookIndex(int shelf, int index)
        {
                return shelf * booksPerShelf + index;
        }

        public boolean setBook(Book book)
        {
                for (int i = 0; i < books.length; ++i) {
                        if (setBookAt(i, book)) {
                                return true;
                        }
                }

                return false;
        }

        public boolean setBookOnShelf(int shelf, Book book)
        {
                for (int i = bookIndex(shelf, 0); i < bookIndex(shelf, getBooksPerShelf()); ++i) {
                        if (setBookAt(i, book)) {
                                return true;
                        }
                }

                return false;
        }

        private boolean setBookAt(int index, Book book)
        {
                if (isEmpty(index)) {
                        books[index] = book;
                        incrementInsertionCount();

                        return true;
                }

                return false;
        }

        private boolean isEmpty(int index)
        {
                return books[index].equals(emptyBook);
        }

        public boolean isEmpty(int shelf, int index)
        {
                return getBookAt(shelf, index).equals(emptyBook);
        }

        public boolean takeBook(Book book)
        {
                for (int i = 0; i < books.length; ++i) {
                        if (takeBookOffAt(i, book)) {
                                return true;
                        }
                }

                return false;
        }

        public boolean takeBookOffShelf(int shelf, Book book)
        {
                for (int i = bookIndex(shelf, 0); i < bookIndex(shelf, getBooksPerShelf()); ++i) {
                        if (takeBookOffAt(i, book)) {
                                return true;
                        }
                }

                return false;
        }

        private boolean takeBookOffAt(int index, Book book)
        {
                if (books[index].equals(book)) {
                        books[index] = emptyBook;
                        incrementRemovalCount();

                        return true;
                }

                return false;
        }

        public boolean moveBookToShelf(int shelf, Book book)
        {
                int freeSlot = findFreeSlotOnShelf(shelf);

                if (-1 == freeSlot) {
                        return false;
                }

                if (!takeBook(book)) {
                        return false;
                }

                return setBookAt(freeSlot, book);
        }

        public boolean swapBooks(Book book1, Book book2)
        {
                if (book1.equals(book2)) {
                        return true;
                }

                int index1 = findBookIndex(book1);
                int index2 = findBookIndex(book2);

                if (index1 == -1 || index2 == -1) {
                        return false;
                }

                books[index1] = book2;
                books[index2] = book1;

                return true;
        }

        private int findFreeSlotOnShelf(int shelf)
        {
                for (int i = bookIndex(shelf, 0); i < bookIndex(shelf, getBooksPerShelf()); ++i) {
                        if (isEmpty(i)) {
                                return i;
                        }
                }

                return -1;
        }

        private int findBookIndex(Book book)
        {
                for (int i = 0; i < books.length; ++i) {
                        if (book.equals(books[i])) {
                                return i;
                        }
                }

                return -1;
        }
}
