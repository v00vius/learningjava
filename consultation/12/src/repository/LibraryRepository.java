package repository;

import entity.LibraryItem;

import java.util.List;

public interface LibraryRepository<T extends LibraryItem> {

    public List<T> findAll();

    void add(T item);
}
