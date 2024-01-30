import java.util.Comparator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Presision  {
static public final float EPSILON = 1e-3f;

public static void main(String[] args)
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

        Map<Vec2, Integer> positions = new TreeMap<>(cmpVec2);
        Random rnd = new Random(System.currentTimeMillis());

        for (int i = 0; i < 10_000_000; ++i) {
                Vec2 position = nextVec2(rnd);
                Integer value = positions.get(position);

                if(value == null)
                        positions.put(position, 1);
                else
                        positions.put(position, ++value);
        }

        System.out.println(positions.size());
        System.out.println(positions);
}

private static Vec2 nextVec2(Random rnd)
{
        float baseX = (float) rnd.nextInt(10);
        float baseY = (float) rnd.nextInt(10);

        float x = baseX + rnd.nextFloat(-EPSILON / 2.f, +EPSILON / 2.f);
        float y = baseY + rnd.nextFloat(-EPSILON / 2.f, +EPSILON / 2.f);

        return new Vec2(x, y);
}
}
