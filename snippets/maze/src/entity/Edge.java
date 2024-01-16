package entity;

import java.util.Objects;

public class Edge extends Pair<Node, Node> implements Comparable<Edge> {
        public Edge(Node e1, Node e2)
        {
                super(e1, e2);
        }

        @Override
        public int compareTo(Edge o)
        {
                int rc = first.compareTo(o.first);

                return rc == 0 ? second.compareTo(o.second) : rc;
        }

        @Override
        public int hashCode()
        {
                return Objects.hash(first, second);
        }

        @Override
        public boolean equals(Object o)
        {
                Edge e = (Edge) o;

                return first.equals(e.first) && second.equals(e.second);
        }
}
