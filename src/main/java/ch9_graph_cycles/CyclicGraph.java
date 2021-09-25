package ch9_graph_cycles;

import ch7_graph_search.BFS;
import ch7_graph_search.Graph;
import ch7_graph_search.Vertex;


public class CyclicGraph extends Graph {

    public static Graph createGraph() {
        var g = new CyclicGraph();
        var nodes = new String[]{"A", "B", "C", "D", "E"};
        for (String node : nodes) {
            g.addVertex(node);
        }

        g.addEdge("A","B");
        g.addEdge("A","C");
        g.addEdge("C","D");
        g.addEdge("B","D");
        g.addEdge("E", "B");
        g.addEdge("D","E");
        g.addEdge("D","A");

        return g;
    }

    @Override
    public void addEdge(String first, String second) {
        getFriends().get(new Vertex(first)).add(new Vertex(second));
    }


    public static void main(String[] args) {
        var g = CyclicGraph.createGraph();
        var dfs = new DFS(g);

//        dfs.search("A", "|");

        var bfs = new BFS(g);
        System.out.println(bfs.isCycle("A"));

    }
}
