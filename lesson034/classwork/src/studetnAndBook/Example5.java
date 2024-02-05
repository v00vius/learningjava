package studetnAndBook;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example5 {
    /*
Студент записывает книги которые прочитал,
задача вывести все прочитанные книги у всех студентов
(в качестве дополнения, применить фильтр на тему: найти книги которые не содержат HTML)
 */

    public static void main(String[] args) {
        Student student1 = new Student("Alex");
        student1.addBook("Java 8 vs Java 21");
        student1.addBook("Spring Boot in Action");
        student1.addBook("Effective Java");

        Student student2 = new Student("Thomas");
        student2.addBook("HTML introducing");
        student2.addBook("Effective Java");


        List<Student> students = Stream.of(student1, student2)
                .toList();

        System.out.println("# 1 ------------------");
        System.out.println(students);

        Set<String> booksRead = students.stream()
                .flatMap(student -> student.getBook().stream())
                .collect(Collectors.toSet());

        System.out.println("# 2 ------------------");
        System.out.println(booksRead);

        Supplier<Integer> id = new Supplier<Integer>() {
            private static int counter = 0;
            @Override
            public Integer get()
            {
                return ++counter;
            }
        };

        String booksNoHTML = students.stream()
                .flatMap(student -> student.getBook().stream())
                .filter(book -> !book.toLowerCase().contains("html"))
                .map(book -> id.get() + ") " + book)
                .collect(Collectors.joining("\n"));

        System.out.println("# 3 ------------------");
        System.out.println(booksNoHTML);

    }
}
