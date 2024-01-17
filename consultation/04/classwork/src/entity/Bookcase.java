package types;

import java.util.Arrays;

public class Bookcase {
        Bookshelf[] bookshelves;

        public Bookcase(int totalNumberOfShelves)
        {
                this.bookshelves = new Bookshelf[totalNumberOfShelves];
        }

        public Bookshelf[] getBookshelves()
        {
                return bookshelves;
        }

        @Override
        public String toString()
        {
                return "Bookcase{" +
                       "bookshelves=" + Arrays.toString(bookshelves) +
                       '}';
        }
}
