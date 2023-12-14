package service;

import entity.*;

public class BookService {

    public Book[] createBookStorage(int size) {
        return new Book[size];
    }

    public boolean addBookToStore(Book[] store, Book aBook) {
        int position = findFreePlace(store);

        if(-1 == position)
            return false;

        store[position] = aBook;

        return true;
    }

    private int findFreePlace(Book[] store) {
        for (int i = 0; i < store.length; i++) {
            if(store[i] == null)
                return i;
        }

        return -1;
    }
}
