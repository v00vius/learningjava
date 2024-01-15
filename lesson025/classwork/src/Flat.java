public class Flat implements Comparable <Flat>{
private float area;
private int nRooms;

public Flat(float area, int nRooms)
{
        this.area = area;
        this.nRooms = nRooms;
}

public float getArea()
{
        return area;
}

public int getnRooms()
{
        return nRooms;
}

@Override
public String toString()
{
        return "Flat {" +
                "area=" + area +
                " m^2, nRooms=" + nRooms +
                "}\n";
}

        @Override
        public int compareTo(Flat o)
        {
                int cmp = getnRooms() - o.getnRooms();
                return cmp == 0 ? (int)(getArea() - o.getArea()) : cmp;
        }
}
