package studetnAndBook;

import java.util.HashSet;
import java.util.Set;

public class Student {
    private static int idCounter = 0;
    private int id;
    private String name;
    private Set<String> book;

    public Student( String name) {
        this.id = idCounter++;
        this.name = name;
        this.book = new HashSet<>();
    }

    public void addBook(String book){
            this.book.add(book);
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public Set<String> getBook() {
        return book;
    }


    @Override
    public String toString() {
        return "\nStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", book=" + book +
                '}';
    }
}
