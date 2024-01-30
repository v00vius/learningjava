import java.util.Comparator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Positions {
static public final float EPSILON = 1e-3f;
private Map<Vec2, Integer> positions;

public Positions()
{
        Comparator<Float> cmpFloat = (f1, f2) ->
        {
                float difference = Math.abs(f1 - f2);

                if(difference <= EPSILON)
                        return 0;

                return f1 < f2 ? -1 : +1;
        };

        Comparator<Vec2> cmpVec2 = (v1, v2) ->
        {
                int cmp = cmpFloat.compare(v1.x(), v2.x());

                if(cmp == 0)
                        cmp = cmpFloat.compare(v1.y(), v2.y());

                return cmp;
        };

        positions = new TreeMap<>(cmpVec2);
}
public int addPosition(Vec2 position)
{
        Integer value = positions.computeIfAbsent(position, k -> 0);

        positions.put(position, ++value);

        return value;
}

public int size()
{
        return positions.size();
}
public float[] getPositions()
{
        float[] result = new float[2 * positions.size()];
        int i = 0;

        for (Vec2 v : positions.keySet()) {
                result[i] = v.x();
                result[i + 1] = v.y();
                positions.put(v, i / 2);

                i += 2;
        }

        return result;
}

@Override
public String toString()
{
        StringBuilder builder = new StringBuilder("Positions\n");
        int i = 0;

        for (Vec2 v : positions.keySet()) {
                builder.append("  ")
                        .append(i)
                        .append(" - (")
                        .append(v.x())
                        .append(',')
                        .append(v.y())
                        .append(")=")
                        .append(positions.get(v))
                        .append('\n');

                ++i;
        }

        return builder.toString();
}

public static void main(String[] args)
{
        Random rnd = new Random(System.currentTimeMillis());
        Positions positions = new Positions();

        for (int i = 0; i < 10_000_000; ++i) {
                Vec2 position = nextVec2(rnd);
                positions.addPosition(position);
        }

        float[] pts = positions.getPositions();

        for (int i = 0; i < pts.length; i += 2) {
                System.out.println( i / 2 + " - (" + pts[i] + "," + pts[i + 1] + ")");
        }

        System.out.println("size=" + positions.size());
        System.out.println(positions);
}

private static Vec2 nextVec2(Random rnd)
{
        float baseX = (float) rnd.nextInt(5);
        float baseY = (float) rnd.nextInt(5);

        float x = baseX + rnd.nextFloat(-EPSILON / 2.f, +EPSILON / 2.f);
        float y = baseY + rnd.nextFloat(-EPSILON / 2.f, +EPSILON / 2.f);

        return new Vec2(x, y);
}
}
