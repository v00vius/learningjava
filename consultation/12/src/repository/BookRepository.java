package repository;

import entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository implements LibraryRepository<Book> {

   private List<Book> books = new ArrayList<>();

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public void add(Book item) {
        books.add(item);
    }
}
