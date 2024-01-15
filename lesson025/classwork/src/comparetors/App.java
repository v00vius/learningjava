package comparetors;

import java.util.*;

public class App {
        public static void main(String[] args)
        {
                Comparator<Flat> cmp1 = new FlatByRooms().thenComparing(new FlatByArea());
                Set<Flat> flats = new TreeSet<>(cmp1);
                Random rnd = new Random();

                for (int i = 0; i < 10; ++i) {
                        flats.add(new Flat(rnd.nextFloat(40, 100),
                                rnd.nextInt(1, 5)));
                }

                System.out.println(flats);

                Comparator<Bag> cmp2 = new BagBySize().thenComparing(new BagByMaterial()).thenComparing(new BagByColor());
                List<Bag> bags = new LinkedList<>();
                Set<Bag> set = new TreeSet<>(cmp2);

                for (int i = 0; i < 10; ++i) {
                        Bag bag = new Bag(rnd.nextInt(1, 2),
                                rnd.nextInt(1, 3),
                                rnd.nextInt(1, 10)
                        );

                        bags.add(bag);
                        set.add(bag);

                }

                System.out.println(bags);
                Collections.sort(bags, cmp2);
                System.out.println("LinkedList +++++++++++++++++++++++++++++++++++");
                System.out.println(bags);

                System.out.println("TreeSet +++++++++++++++++++++++++++++++++++");
                System.out.println(set);
        }
}
