package comparetors;

import java.util.Comparator;

public class FlatByRooms implements Comparator<Flat> {
        @Override
        public int compare(Flat o1, Flat o2)
        {
                return o1.getnRooms() - o2.getnRooms();
        }
}
