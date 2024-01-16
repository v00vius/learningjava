package entity;

import java.util.HashSet;
import java.util.Set;

public class Graph {
        private Set<Node> vertices;

        public Graph()
        {
                vertices = new HashSet<>();
        }

        public int add(Node n)
        {
                vertices.add(n);

                return vertices.size();
        }

        public Set<Node> getVertices()
        {
                return vertices;
        }
}
