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
        area = new Bits(2 + cols, 2 + rows);
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

        for (int x = 0; x < area.getSize_x(); ++x) {
                area.set(x, 0);
                area.set(x, area.getSize_y() - 1);
        }

        for (int y = 1; y < area.getSize_y() - 1; ++y) {
                area.set(0, y);
                area.set(area.getSize_x() - 1, y);
        }


        wave.clear();
        graph.clear();

        int idx = index(rnd.nextInt(cols), rnd.nextInt(rows));
        Edge e = new Edge(idx, idx);

        graph.add(e);
        area.set(idx);

        System.out.println(area);

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
        if(area.get(p))
                return;

        wave.add(new Edge(p, p1));
}
public int step(int p1)
{
        addWave(p1 - 1, p1);
        addWave(p1 + 1, p1);
        addWave(p1 - cols - 2, p1);
        addWave(p1 + cols + 2, p1);

        Edge edge;

        do {
                if(wave.isEmpty())
                        return -1;

                int i = rnd.nextInt(wave.size());

                edge = wave.remove(i);
        }
        while (area.get(edge.getFrom()));

        graph.add(edge);
        area.set(edge.getFrom());

        return edge.getFrom();
}

@Override
public String toString()
{
        StringBuilder s = new StringBuilder(String.format("Graph: %d edges\n", graph.size()));
        int i = 0;

        for (Edge e : graph) {
                s.append(i++).append(": ").append(e.getFrom()).append(" -> ").append(e.getTo()).append("\n");
        }

        return s.toString();
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
private final int size_x;
private final int size_y;
private long[] bits;
static private final int MIN_BITS = 64;
        public Bits(int size)
        {
                size_x = size_y = 0;
                init(size);
        }
        public Bits(int size_x, int size_y)
        {
                this.size_x = size_x;
                this.size_y = size_y;
                init(size_x * size_y);
        }
        private void init(int size)
        {
                int sz = size / MIN_BITS;

                if(0 != size % MIN_BITS)
                        ++sz;

                bits = new long[sz];
        }
        public int getSize_x()
        {
                return size_x;
        }

        public int getSize_y()
        {
                return size_y;
        }
        public boolean get(int i)
        {
                int theWord = i / MIN_BITS;
                int theBit = i % MIN_BITS;

                return (bits[theWord] & (1L << theBit)) != 0;
        }
        public boolean get(int x, int y)
        {
                return get(index(x, y));
        }
        private int index(int x, int y)
        {
                return size_x * y + x;
        }
        public void set(int i)
        {
                int theWord = i / MIN_BITS;
                int theBit = i % MIN_BITS;

                bits[theWord] |= 1L << theBit;
        }
        public void set(int x, int y)
        {
                set(index(x, y));
        }
        public void clr(int i)
        {
                int theWord = i / MIN_BITS;
                int theBit = i % MIN_BITS;

                bits[theWord] &= ~(1L << theBit);
        }
        public void clr(int x, int y)
        {
                clr(index(x, y));
        }
        public void clear()
        {
                Arrays.fill(bits, 0);
        }

        @Override
        public String toString()
        {
                StringBuilder s = new StringBuilder(String.format("Bits: %d long int's\n", bits.length));

                for (int y = 0; y < size_y; ++y) {
                        s.append(String.format("%03d:", y));

                        for (int x = 0; x < size_x; ++x) {
                                s.append(get(x, y) ? '1' : '0');
                        }

                        s.append('\n');
                }

                return s.toString();
        }
}
}
