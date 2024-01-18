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
static public final byte INVALID = (byte)0xFF;
static public final byte FLOOR = (1 << 4);
static public final byte RIGHT = (2 << 4);
static public final byte STATE = 0x0F;
static public final byte PASS = (byte)0xF0;
static private int[] dx = {-1, 0, 0, 1};
static private int[] dy = {0, -1, 1, 0};

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

public int getRows()
{
        return rows;
}

public int getCols()
{
        return cols;
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
//        return valid(x, y) ? get(index(x, y), mask) : INVALID;
}
private void setState(int idx, byte state)
{
        area[idx] = (byte)(state | (area[idx] & ~STATE));
}
private void setState(int x, int y, byte state)
{
        setState(index(x, y), state);
}
private void setBorder(int idx, byte border)
{
        area[idx] |= border;
}
//private byte getBorder(int idx)
//{
//        return get(idx, BORDER);
//}
private byte getBorder(int x, int y)
{
        return get(index(x, y), PASS);
}
public boolean valid(int x, int y)
{
        return x >= 0 && x < cols && y >= 0 && y < rows;
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
        int x = rnd.nextInt(0, cols);
        int y = rnd.nextInt(0, rows);

        fill();
        graph.clear();
        wave.clear();
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
        wave(true);

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

private int wave(boolean lastAdded)
{
        if (lastAdded) {
                int idx = graph.getLast().getFrom();
                int x0 = getX(idx);
                int y0 = getY(idx);

                return wave2(x0, y0);
        }

        Iterator<Edge> begin = graph.iterator();
        int counter = 0;

        while (begin.hasNext()) {
                int idx = begin.next().getFrom();
                int x0 = getX(idx);
                int y0 = getY(idx);

                counter += wave(x0, y0);
        }

        return counter;
}

private int wave(int x0, int y0)
{
        int count = 0;
        byte state = get(x0, y0, STATE);

        if (state != GRAPH)
                return count;

        int p0 = index(x0, y0);

        for (int i = 0; i < dx.length; ++i) {
                int x = x0 + dx[i];
                int y = y0 + dy[i];

                state = get(x, y, STATE);

                if (state != EMPTY)
                        continue;

                int p1 = index(x, y);
                Edge e = new Edge(p1, p0);

                waveAdd(e);
                ++count;
        }

        return count;
}

private int addFront(int p, int p0)
{
        int count = 0;
        byte state = get(p, STATE);

        if (state == EMPTY) {
                Edge e = new Edge(p, p0);

                waveAdd(e);
                ++count;
        }

        return count;
}
private int wave2(int x0, int y0)
{
        int count;
        int p0 = index(x0, y0);

        count  = addFront(p0 - 1, p0);
        count += addFront(p0 + 1, p0);
        count += addFront(p0 - cols - 2, p0);
        count += addFront(p0 + cols + 2, p0);

        return count;
}

private int addWave(int p0, int count)
{
        byte state;
        state = get(p0 + 1, STATE);

        if (state == EMPTY) {
                Edge e = new Edge(p0 + 1, p0);

                waveAdd(e);
                ++count;
        }
        return count;
}

private void waveAdd(Edge e)
{
        wave.add(e);
        setState(e.getFrom(), WAVE);
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
