import javax.xml.stream.events.EndDocument;
import java.util.*;

public class Maze2D {
private int rows;
private int cols;
private byte[] area;
static private Random rnd = new Random(System.currentTimeMillis());

private List<Edge> wave;
private List<Edge> graph;
static public final byte EMPTY = 0x00;
static public final byte GRAPH = 0x01;
static public final byte WAVE = 0x02;
static public final byte INVALID = 0x10;
static public final byte FLOOR = 0x11;
static public final byte RIGHT = 0x12;
static public final byte STATE = (GRAPH | WAVE);
static public final byte BORDER = (FLOOR | RIGHT);
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
        this.area = new byte[rows * cols];
        fill(EMPTY);
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

public byte get(int x, int y, byte mask)
{
        return valid(x, y) ? (byte) (mask & area[index(x, y)]) : INVALID;
}
public boolean valid(int x, int y)
{
        return x >= 0 && x < cols && y >= 0 && y < rows;
}
public void init()
{
        int x = rnd.nextInt(0, cols);
        int y = rnd.nextInt(0, rows);

        fill(EMPTY);
        graph.clear();
        wave.clear();
        int idx = index(x, y);

        graphAdd(new Edge(idx, idx));
}

private void graphAdd(Edge e)
{
        graph.add(e);

        int x = getX(e.getFrom());
        int y = getY(e.getFrom());

        setState(x, y, GRAPH);
}

public boolean step()
{
        wave(true);

        if (wave.isEmpty())
                return false;

        int i = rnd.nextInt(0, wave.size());
        Edge e = wave.get(i);

        wave.remove(i);
        graphAdd(e);

        return true;
}

private int wave(boolean lastAdded)
{
        if (lastAdded) {
                int idx = graph.getLast().getFrom();
                int x0 = getX(idx);
                int y0 = getY(idx);

                return wave(x0, y0);
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

private void waveAdd(Edge e)
{
        wave.add(e);
        setState(e.getFrom(), WAVE);
}

private void fill(byte state)
{
        Arrays.fill(area, state);
}

private void setState(int idx, byte state)
{
        area[idx] = (byte)(state | (area[idx] & ~STATE));
}
private boolean setState(int x, int y, byte state)
{
        if (valid(x, y)) {
                setState(index(x, y), state);

                return true;
        } else {
                return false;
        }
}


private int index(int x, int y)
{
        return cols * y + x;
}

private int getX(int idx)
{
        return idx % cols;
}

private int getY(int idx)
{
        return idx / cols;
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
                } else if (-cols == distance) {
                        setBorder(p1, FLOOR);
                } else if (cols == distance) {
                        setBorder(p0, FLOOR);
                }
        }
}
private void setBorder(int idx, byte border)
{
        area[idx] |= border;
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
                                m += '*';
                        } else if (location == WAVE) {
                                m += 'o';
                        } else if (location == EMPTY) {
                                m += '.';
                        } else {
                                m += '?';
                        }

                        location = get(x, y, BORDER);

                        if(RIGHT == (location & RIGHT))
                                m += ' ';
                        else
                                m += '|';
                }

                m += "\n    ";

                for (int x = 0; x < cols; ++x) {
                        byte location = get(x, y, BORDER);

                        if(FLOOR == (location & FLOOR))
                                m += " +";
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
