package maze2;

import java.util.*;

public class Maze2D {
private int rows;
private int cols;
private byte[] area;
static private Random rnd = new Random(31);
//static private Random rnd = new Random(System.currentTimeMillis());

private List<Edge> wave;
private List<Edge> graph;
static public final byte EMPTY = 0;
static public final byte GRAPH = 1;
static public final byte WAVE = 2;
static public final byte OUTER = 3;
static public final byte FLOOR = (1 << 4);
static public final byte RIGHT = (2 << 4);
static public final byte STATE = 0x0F;
static public final byte PASS = (byte)0xF0;

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
}
public Maze2D(int rows, int cols)
{
        this.rows = rows;
        this.cols = cols;
        this.area = new byte[(2 + rows) * (2 + cols)];
        wave = new ArrayList<>();
        graph = new ArrayList<>();
}

public List<Edge> getGraph()
{
        return graph;
}

public int size()
{
        return rows * cols;
}

public byte get(int idx, byte mask)
{
        return (byte) (mask & area[idx]);
}
public byte get(int x, int y, byte mask)
{
        return get(index(x, y), mask);
}
private void setState(int idx, byte state)
{
        area[idx] = (byte)(state | (area[idx] & ~STATE));
}

private void setBorder(int idx, byte border)
{
        area[idx] |= border;
}
private byte getBorder(int x, int y)
{
        return get(index(x, y), PASS);
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

public void init()
{
        fill();
        graph.clear();
        wave.clear();

        int x = rnd.nextInt(0, cols);
        int y = rnd.nextInt(0, rows);
        int idx = index(x, y);

        graphAdd(new Edge(idx, idx));
}
private void graphAdd(Edge e)
{
        graph.add(e);
        setState(e.getFrom(), GRAPH);
}
public boolean step()
{
        int p0 = graph.getLast().getFrom();

        addFront(p0 - 1, p0);
        addFront(p0 + 1, p0);
        addFront(p0 - cols - 2, p0);
        addFront(p0 + cols + 2, p0);

        Edge e;

        do {
                if (wave.isEmpty())
                        return false;

                int i = rnd.nextInt(0, wave.size());

                e = wave.remove(i);
        }
        while (GRAPH == get(e.getFrom(), STATE));

        graphAdd(e);

        return true;
}
private int addFront(int p, int p0)
{
        int count = 0;
        byte state = get(p, STATE);

        if (state == EMPTY) {
                Edge e = new Edge(p, p0);

                wave.add(e);
//                setState(e.getFrom(), WAVE);
                ++count;
        }

        return count;
}
private void fill()
{
        Arrays.fill(area, 0, cols + 2, OUTER);

        for (int y = 0 ; y < rows; ++y) {
                area[index(-1, y )] = OUTER;
                Arrays.fill(area, index(0, y), index(cols, y), EMPTY);
                area[index(cols, y )] = OUTER;
        }

        Arrays.fill(area, index(-1, rows), index(cols, rows ), OUTER);
}
public void createBorders()
{
        for(Edge e : graph) {
                int p0 = e.getFrom();
                int p1 = e.getTo();
                int distance = p1 - p0;

                if(1 == distance) {
                        setBorder(p0, RIGHT);
                } else if (-1 == distance) {
                        setBorder(p1, RIGHT);
                } else if (-(2 + cols) == distance) {
                        setBorder(p1, FLOOR);
                } else if ((2 + cols) == distance) {
                        setBorder(p0, FLOOR);
                }
        }
}

@Override
public String toString()
{
        String m = String.format("Maze2D: rows %d, cols %d, size %d\n", rows, cols, size());

        for (int y = 0; y < rows; ++y) {
                m += String.format("%03d ", y);

                for (int x = 0; x < cols; ++x) {
                        byte location = get(x, y, STATE);

                        if (location == GRAPH) {
                                m += '.';
                        } else if (location == WAVE) {
                                m += 'o';
                        } else if (location == EMPTY) {
                                m += ' ';
                        } else {
                                m += '?';
                        }

                        location = getBorder(x, y);

                        if(RIGHT == (location & RIGHT))
                                m += '.';
                        else
                                m += '|';
                }

                m += "\n    ";

                for (int x = 0; x < cols; ++x) {
                        byte location = getBorder(x, y);

                        if(FLOOR == (location & FLOOR))
                                m += ".+";
                        else
                                m += "-+";
                }

                m += '\n';
        }

        m += String.format("Graph (%d) edges:", graph.size());

        for (Edge e : graph) {
                m += String.format(" [%d->%d]", e.getFrom(), e.getTo());
        }

        m += String.format("\nWave (%d) edges:", wave.size());

        for (Edge e : wave) {
                m += String.format(" [%d->%d]", e.getFrom(), e.getTo());
        }

        return m;
}
}
