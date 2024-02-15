package repository;

import entity.Book;
import entity.Magazine;

import java.util.ArrayList;
import java.util.List;

public class MagazineRepository implements LibraryRepository<Magazine> {

   private List<Magazine> magazines = new ArrayList<>();


    @Override
    public List<Magazine> findAll() {
        return magazines;
    }

    @Override
    public void add(Magazine item) {
        magazines.add(item);
    }
}
