import java.util.*;

public class Positions {
static public final float EPSILON = 1e-4f;
private Map<Vec2, Vec2> positions;
private List<Triangle> triangles;
public Comparator<Vec2> compareVec2;
public Positions()
{
        compareVec2 = (v1, v2) ->
        {
                int cmp = compareFloat(v1.x(), v2.x());

                if(cmp == 0)
                        cmp = compareFloat(v1.y(), v2.y());

                return cmp;
        };

        positions = new TreeMap<>(compareVec2);
        triangles = new ArrayList<>();
}
static public int compareFloat(float f1, float f2)
{
        float difference = Math.abs(f1 - f2);

        if(difference <= EPSILON)
                return 0;

        return f1 < f2 ? -1 : +1;
}
public Vec2 add(Vec2 position)
{
        return positions.computeIfAbsent(position, k -> position);
}
public void add(Triangle triangle)
{
        triangle.setP0(add(triangle.getP0()));
        triangle.setP1(add(triangle.getP1()));
        triangle.setP2(add(triangle.getP2()));

        triangles.add(triangle);
}

public int size()
{
        return positions.size();
}
public float[] getPositions()
{
        float[] positionsArray = new float[2 * positions.size()];
        int i = 0;

        for (Vec2 v : positions.keySet()) {
                positionsArray[i++] = v.x();
                positionsArray[i++] = v.y();
        }

        return positionsArray;
}
public int[] getTriangles()
{
        int[] vertices = new int[3 * triangles.size()];
        Map<Vec2, Integer> indices = new HashMap<>();

        for (Vec2 v : positions.keySet())
                indices.computeIfAbsent(v, k -> indices.size());

        int i = 0;

        for (Triangle triangle : triangles) {
                System.out.print("triangle " + i / 3 + ": ");
                triangle.counterClock();

                int idx = indices.get(triangle.getP0());
                vertices[i++] = idx;

                idx = indices.get(triangle.getP1());
                vertices[i++] = idx;

                idx = indices.get(triangle.getP2());
                vertices[i++] = idx;
        }

        return vertices;
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
                        .append(")\n");

                ++i;
        }

        builder.append("Triangles\n");
        i = 0;

        for (Triangle triangle : triangles) {
                builder.append("  ")
                        .append(i)
                        .append(" - ")
                        .append(triangle).append('\n');

                ++i;
        }

        return builder.toString();
}

public static void main(String[] args)
{
        Random rnd = new Random(System.currentTimeMillis());
        Positions positions = new Positions();

        for (int i = 0; i < 50; ) {
                Vec2 p0, p1, p2;

                p0 = nextVec2(rnd);

                for(p1 = nextVec2(rnd); 0 == positions.compareVec2.compare(p1, p0);)
                        p1 = nextVec2(rnd);

                for(p2 = nextVec2(rnd);
                    0 == positions.compareVec2.compare(p2, p1) ||
                    0 == positions.compareVec2.compare(p2, p0);) {

                        p2 = nextVec2(rnd);
                }

                Triangle triangle = new Triangle(p0, p1, p2);

                positions.add(triangle);
                ++i;
        }

        float[] pts = positions.getPositions();

        for (int i = 0; i < pts.length; i += 2) {
                System.out.println( i / 2 + " - (" + pts[i] + "," + pts[i + 1] + ")");
        }

        System.out.println("size=" + positions.size());
        System.out.println(positions);

        int[] vertices = positions.getTriangles();

        for (int i = 0; i < vertices.length; i += 3) {
                System.out.printf("%d) {%d, %d, %d}\n", i / 3, vertices[i], vertices[i + 1], vertices[i + 2]);
        }
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
