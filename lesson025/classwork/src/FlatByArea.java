import java.util.Comparator;

public class FlatByArea implements Comparator<Flat> {
@Override
public int compare(Flat o1, Flat o2)
{
        return (int)(o1.getArea() - o2.getArea());
}
}
