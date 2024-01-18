package maze3;

import java.util.*;

public class Maze2D {
private final int rows;
private final int cols;
private BitSet area;
static private Random rnd = new Random(31);
private List<Edge> wave;
private List<Edge> graph;

public Maze2D(int rows, int cols)
{
        this.rows = rows;
        this.cols = cols;
        area = new BitSet(rows * cols);
        wave = new ArrayList<>();
        graph = new LinkedList<>();
}

public Edge init()
{
        area.clear();
        wave.clear();
        graph.clear();

        int idx = rnd.nextInt(rows * cols);
        Edge e = new Edge(idx, idx);

        graph.add(e);
        area.set(idx);

        return  e;
}

private void addWave(Edge edge)
{
        int p = edge.getFrom();
        int x = p % cols;
        int y = p / rows;

        if(x >= 0 && x < cols && y >= 0 && y < rows
                && !area.get(p))
                wave.add(edge);
}
private int wave(Edge e)
{
        addWave(new Edge(e.getFrom() - 1, e.getFrom()));
        addWave(new Edge(e.getFrom() + 1, e.getFrom()));
        addWave(new Edge(e.getFrom() - cols, e.getFrom()));
        addWave(new Edge(e.getFrom() + cols, e.getFrom()));

        return wave.size();
}
public Edge step(Edge edge)
{
        if(0 == wave(edge))
                return null;

        int i = rnd.nextInt(wave.size());

        edge = wave.remove(i);
        graph.add(edge);
        area.set(edge.getFrom());

        return  edge;
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
}
