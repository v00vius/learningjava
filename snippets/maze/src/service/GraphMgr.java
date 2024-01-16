package service;

import entity.Graph;
import entity.Node;

import java.util.Set;

public class GraphMgr {
        public GraphMgr()
        {
        }

        public Graph createGraph(int rows, int cols)
        {
                Graph g = new Graph();

                for (int y = 0; y < rows; ++y) {
                        for (int x = 0; x < cols; ++x) {
                                Node n = new Node(nodeId(rows, y, x));

                                g.add(n);
                        }
                }

                Set<Node> nodes = g.getVertices();


                return g;
        }

        static private int nodeId(int rows, int y, int x)
        {
                return rows * y + x;
        }
}
