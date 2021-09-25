package ch7_graph_search;

public class Demo {
    public static void main(String[] args) {
        var graph = Graph.createGraph();
        var search = new BFS(graph);
        System.out.println(search.find("Bob", "Mark"));
    }
}
