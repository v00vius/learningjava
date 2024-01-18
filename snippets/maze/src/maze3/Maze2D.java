package maze3;

import java.util.*;

public class Maze2D {
private final int rows;
private final int cols;
private Bits area;
static private Random rnd = new Random(31);
private List<Edge> wave;
private List<Edge> graph;

public Maze2D(int rows, int cols)
{
        this.rows = rows;
        this.cols = cols;
        area = new Bits((2 + rows) * (2 + cols));
        wave = new ArrayList<>();
        graph = new LinkedList<>();
}

public List<Edge> getGraph()
{
        return graph;
}

public int init()
{
        area.clear();

        for (int x = -1; x < cols + 1; ++x) {
                area.set(index(x, -1));
                area.set(index(x, rows));
        }

        for (int y = 0; y < rows; ++y) {
                area.set(index(-1, y));
                area.set(index(cols, y));
        }

//        System.out.println(area);

        wave.clear();
        graph.clear();

        int idx = index(rnd.nextInt(cols), rnd.nextInt(rows));
        Edge e = new Edge(idx, idx);

        graph.add(e);
        area.set(idx);

        return e.getFrom();
}
private int index(int x, int y)
{
        return (2 + cols) * (1 + y) + x + 1;
}
private int getX(int idx)
{
        return (idx - 1) % (cols + 2);
}
private int getY(int idx)
{
        return (idx - 1) / (cols + 2) - 1;
}

private void addWave(int p, int p1)
{
        if(area.isSet(p))
                return;

//        int x = getX(p);
//        int y = getY(p);
        wave.add(new Edge(p, p1));
}
private int wave(int p1)
{
        addWave(p1 -    1, p1);
        addWave(p1 +    1, p1);
        addWave(p1 - cols - 2, p1);
        addWave(p1 + cols + 2, p1);

        return wave.size();
}
public int step(int p)
{
        if(0 == wave(p))
                return -1;

        Edge edge;

        do {
                int i = rnd.nextInt(wave.size());

                edge = wave.remove(i);
        }
        while (!wave.isEmpty() && area.isSet(edge.getFrom()));

        if(wave.isEmpty())
                return -1;

        graph.add(edge);
        area.set(edge.getFrom());

        return edge.getFrom();
}

@Override
public String toString()
{
        String s = "Graph:";

        for (Edge e : graph) {
                s += " [" + e.getFrom() + "->" + e.getTo() + "]";
        }

        return s;
}

public class Edge {
        private int from;
        private int to;

        public Edge(int from, int to)
        {
                this.from = from;
                this.to = to;
        }

        public int getFrom()
        {
                return from;
        }

        public int getTo()
        {
                return to;
        }

        @Override
        public int hashCode()
        {
                return from;
        }

        @Override
        public boolean equals(Object o)
        {
                return from == ((Edge)o).getFrom();
        }
}
private class Bits {
private long[] bits;
static private final int MIN_BITS = 64;
        public Bits(int size)
        {
                int sz = size / MIN_BITS;

                if(0 != size % MIN_BITS)
                        ++sz;

                bits = new long[sz];
        }
        public boolean isSet(int i)
        {
                int theWord = i / MIN_BITS;
                int theBit = i % MIN_BITS;

                return (bits[theWord] & (1L << theBit)) != 0;
        }
        public void set(int i)
        {
                int theWord = i / MIN_BITS;
                int theBit = i % MIN_BITS;

                bits[theWord] |= 1L << theBit;
        }
        public void clr(int i)
        {
                int theWord = i / MIN_BITS;
                int theBit = i % MIN_BITS;

                bits[theWord] &= ~(1L << theBit);
        }
        public void clear()
        {
                Arrays.fill(bits, 0);
        }

        @Override
        public String toString()
        {
                String s = String.format("Bits: %d long int's\n", bits.length);

                for (int y = 0; y < rows + 2; y++) {
                        s += String.format("%03d:", y);

                        for (int x = 0; x < cols + 2; x++) {
                                s += isSet(y * (cols + 2) + x) ? '1' : '0';
                        }

                        s += '\n';
                }

                return s;
        }
}
}
