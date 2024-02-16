package repository;

import entity.LibraryItem;
import entity.Book;
import entity.Magazine;

import java.util.ArrayList;
import java.util.List;

public class LibraryRepo implements LibraryRepository<LibraryItem>{

    private List<LibraryItem> items = new ArrayList<>();


    @Override
    public List<LibraryItem> findAll() {
        return items;
    }

    @Override
    public void add(LibraryItem item) {
        items.add(item);
    }

    public List<Book> findAllBooks(){
        List<Book> books = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item instanceof Book) {
                books.add((Book) item);
            }
        }
        return books;
    }

    public List<Magazine> findAllMagazines(){
        List<Magazine> magazines = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item instanceof Magazine) {
                magazines.add((Magazine) item);
            }
        }
        return magazines;
    }
}
