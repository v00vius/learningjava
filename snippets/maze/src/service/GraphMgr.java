package service;

import entity.Graph;
import entity.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GraphMgr {
        public GraphMgr()
        {
        }

        public Graph createGraph(int rows, int cols)
        {
                Graph g = new Graph();
                List<Node> nodes = new ArrayList<>(rows * cols);

                for (int y = 0; y < rows; ++y) {
                        for (int x = 0; x < cols; ++x) {
                                Node n = new Node(index(rows, y, x));

                                nodes.set(n.getId(), n);
                        }
                }

                for (int y = 0; y < rows; ++y) {
                        for (int x = 0; x < cols; ++x) {
                                Node n = nodes.get(index(rows, y, x));

                                connect(nodes, n, x - 1, y, rows, cols);
                                connect(nodes, n, x + 1, y, rows, cols);
                                connect(nodes, n, x, y - 1, rows, cols);
                                connect(nodes, n, x , y + 1, rows, cols);

                                g.add(n);
                        }
                }

                return g;
        }
        static private void connect(List<Node> nodes, Node n1, int x, int y, int max_y, int max_x) {
                if(x < 0 || y < 0 || x > max_x - 1 || y > max_y - 1)
                        return;

                Node n2 = nodes.get(index(max_y, y, x));

                n1.connect(n2);
                n2.connect(n1);
        }
        static private int index(int rows, int y, int x)
        {
                return rows * y + x;
        }
}
