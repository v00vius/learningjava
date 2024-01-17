package types;

import java.util.*;

public class Node implements Comparable<Node> {
        private int id;
        private Set<Node> connected;

        public Node(int id)
        {
                this.id = id;
                connected = new HashSet<>();
        }

        public void connect(Node n)
        {
                if (!this.equals(n)) {
                        connected.add(n);
                }
        }

        public Set<Edge> getEdges()
        {
                HashSet<Edge> edges = new HashSet<>();

                for (Node n : connected) {
                        Edge e = new Edge(this, n);

                        edges.add(e);
                }

                return edges;
        }

        public Set<Node> getNodes()
        {
                return connected;
        }

        public int getId()
        {
                return id;
        }

        @Override
        public int compareTo(Node o)
        {
                return id - o.id;
        }

        @Override
        public boolean equals(Object o)
        {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Node node = (Node) o;

                return id == node.id;
        }

        @Override
        public int hashCode()
        {
                return Objects.hash(id);
        }
}
