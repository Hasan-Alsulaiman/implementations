package ch7_graph_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Graph {
    private Map<Vertex, List<Vertex>> friends;

    public Map<Vertex, List<Vertex>> getFriends() {
        return friends;
    }

    public Graph() {
        this.friends = new HashMap<>();
    }

    public void addVertex(String name) {
        friends.putIfAbsent(new Vertex(name), new ArrayList<Vertex>());
    }

    public void removeVertex(String name) {
        friends.remove(new Vertex(name));
    }

    public void addEdge(String first, String second) {
        friends.get(new Vertex(first)).add(new Vertex(second));
        friends.get(new Vertex(second)).add(new Vertex(first));
    }

    void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = friends.get(v1);
        List<Vertex> eV2 = friends.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    public List<Vertex> getFriendsOf(String name) {
        return friends.get(new Vertex(name));
    }

    public static Graph createGraph() {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        return graph;
    }

    @Override
    public String toString() {
        return friends + "";
    }

    public static void main(String[] args) {
        var graph = createGraph();
        System.out.println(graph.getFriendsOf("Bob"));
    }

}
