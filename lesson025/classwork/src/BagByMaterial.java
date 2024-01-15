import java.util.Comparator;

public class BagByMaterial implements Comparator<Bag> {
@Override
public int compare(Bag o1, Bag o2)
{
        return o1.getMaterial() - o2.getMaterial();
}
}
