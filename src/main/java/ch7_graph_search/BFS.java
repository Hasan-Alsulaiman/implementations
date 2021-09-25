package ch7_graph_search;

import java.util.*;
import java.util.stream.Collectors;

public class BFS implements Search{
    Graph graph;

    public BFS(Graph graph) {
        this.graph = graph;
    }

    @Override
    public boolean find(String start, String destination) {
        Queue<Vertex> q = new LinkedList<>();
        var visited = new HashSet<Vertex>();

        q.add(new Vertex(start));
        while (!q.isEmpty()) {
            var current = q.remove();
            if (!visited.contains(current) && current.getLabel().equalsIgnoreCase(destination))
                return true;
            visited.add(current);
            graph.getFriendsOf(current.getLabel()).forEach(element -> {
                if(visited.contains(element))
                    return;
                q.add(element);
            });
        }
        return false;
    }

    public boolean isCycle(String start) {
        var reachable = new ArrayList<String>();
        var front = new ArrayList<String>();
        reachable.addAll(graph.getFriendsOf(start).stream().map(Vertex::getLabel).collect(Collectors.toList()));
        for (int i=0; i<reachable.size(); i++) {
            front.addAll(graph.getFriendsOf(reachable.get(i)).stream().map(Vertex::getLabel).collect(Collectors.toList()));
            if (front.contains(start))
                return true;
            reachable.addAll(front);
        }
        return  false;
    }
}
