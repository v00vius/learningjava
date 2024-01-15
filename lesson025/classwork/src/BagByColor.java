import java.util.Comparator;

public class BagByColor implements Comparator<Bag> {
@Override
public int compare(Bag o1, Bag o2)
{
        return o1.getColor() - o2.getColor();
}
}
