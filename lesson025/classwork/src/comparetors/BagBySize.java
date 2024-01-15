package comparetors;

import java.util.Comparator;

public class BagBySize implements Comparator<Bag> {
        @Override
        public int compare(Bag o1, Bag o2)
        {
                return o1.getSize() - o2.getSize();
        }
}
