import javax.xml.stream.events.EndDocument;
import java.util.*;

public class Maze2D {
private int rows;
private int cols;
private byte[] area;
private Random rnd;

private List<Edge> wave;
private List<Edge> graph;
static private final byte EMPTY = 0x00;
static private final byte GRAPH = 0x01;
static private final byte WAVE = 0x02;
static private final byte INVALID = 0x10;
static int[] dx = {-1, 0, 0, 1};
static int[] dy = {0, -1, 1, 0};

class Edge {
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
        rnd = new Random(System.currentTimeMillis());
        wave = new ArrayList<>();
        graph = new ArrayList<>();
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

        set(x, y, GRAPH);
}

public int step()
{
        wave();

        int i = rnd.nextInt(0, wave.size());
        Edge e = wave.get(i);

        wave.remove(i);
        graphAdd(e);

        return wave.size();
}

public int wave()
{
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

public int wave(int x0, int y0)
{
        int count = 0;

        byte state = get(x0, y0);

        if (state != GRAPH) {
                return count;
        }

        int p0 = index(x0, y0);

        for (int i = 0; i < dx.length; ++i) {
                int x = x0 + dx[i];
                int y = y0 + dy[i];

                int p1 = index(x, y);
                state = get(x, y);

                if (state != EMPTY) {
                        continue;
                }

                Edge e = new Edge(p1, p0);

                wave.add(e);
                area[p1] = WAVE;
                ++count;
        }

        return count;
}

public int size()
{
        return rows * cols;
}

private void fill(byte state)
{
        Arrays.fill(area, state);
}

boolean valid(int x, int y)
{
        return x >= 0 && x < cols && y >= 0 && y < rows;
}

public boolean set(int x, int y, byte state)
{
        if (valid(x, y)) {
                area[index(x, y)] = state;

                return true;
        } else {
                return false;
        }
}

public boolean clear(int x, int y, byte state)
{
        if (valid(x, y)) {
                area[index(x, y)] &= ~state;

                return true;
        } else {
                return false;
        }
}

public byte get(int x, int y)
{
        return valid(x, y) ? area[index(x, y)] : INVALID;
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

@Override
public String toString()
{
        String m = String.format("Maze2D: rows %d, cols %d, size %d\n", rows, cols, size());

        for (int y = 0; y < rows; ++y) {
                m += String.format("%03d ", y);

                for (int x = 0; x < cols; ++x) {
                        byte location = get(x, y);

                        if (location == GRAPH) {
                                m += '*';
                        } else if (location == WAVE) {
                                m += 'o';
                        } else if (location == EMPTY) {
                                m += '.';
                        } else {
                                m += '?';
                        }
                }

                m += '\n';
        }

        m += String.format("Graph (%d) edges:", graph.size());

        for(Edge e : graph) {
                m += String.format(" [%d->%d]", e.getFrom(), e.getTo());
        }

        m += String.format("\nWave (%d) edges:", wave.size());

        for(Edge e : wave) {
                m += String.format(" [%d->%d]", e.getFrom(), e.getTo());
        }

        return m;
}
}
