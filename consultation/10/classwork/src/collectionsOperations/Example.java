package collectionsOperations;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();

        cats.add(new Cat("Barsik"));
        cats.add(new Cat("Murzik"));

        System.out.println(cats);

        Cat cat = new Cat("Murzik");

        cats.remove(cat);

        System.out.println(cats);
    }
}
