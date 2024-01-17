package iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class App {
        private Integer id;

        public App(Integer id)
        {
                this.id = id;
        }

        public static void main(String[] args)
        {
                List<App> list = new ArrayList<>();

                for (int i = 0; i < 10; i++)
                        list.add(new App(i));

                System.out.println(list);

                ListIterator<App> e = list.listIterator(3);

                while (e.hasNext()) {
                        App v = e.next();

                        System.out.println(v);

                        if (v.getId() == 5) {
                                e.remove();
                        }
                }

                System.out.println(list);

        }

        public Integer getId()
        {
                return id;
        }

        public void setId(Integer id)
        {
                this.id = id;
        }

        @Override
        public String toString()
        {
                return id.toString();
        }
}
