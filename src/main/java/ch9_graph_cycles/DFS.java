package ch9_graph_cycles;

import ch7_graph_search.Graph;
import ch7_graph_search.Vertex;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DFS <T extends Graph> {
    T graph;
    private Map<String, String> status;
    public List<String> queue;

    public DFS(T graph) {
        this.queue = new LinkedList<>();
        this.status = new HashMap<>();
        this.graph = graph;

        for (var node : graph.getFriends().keySet()) {
            status.put(node.getLabel(), "not started");
        }

    }

    public boolean isCyclic(String start) {
        if (status.get(start).equalsIgnoreCase("in progress")) {
            return true;
        }
        if (status.get(start).equalsIgnoreCase("not started")) {
            System.out.println(start + " in progress");
            status.put(start, "in progress");
            for (var node : graph.getFriendsOf(start)) {
                    return isCyclic(node.getLabel());
            }
        }

        return false;
    }

    public void search(String start, String spacer) {
        spacer += spacer.charAt(0);
        if (status.get(start).equalsIgnoreCase("in progress")) {
            System.out.print(spacer + "cycle found: ");
            printQFrom(start);
        }
        if (status.get(start).equalsIgnoreCase("not started")) {
            System.out.println(spacer + start + " in progress");
            status.put(start, "in progress");
            queue.add(start);
            for (var node : graph.getFriendsOf(start)) {
                search(node.getLabel(), spacer);
            }
            System.out.println(spacer + start + " done.");
            status.put(start, "done");
            queue.remove(start);
        }

    }

    private void printQFrom(String node) {
        for (int i = queue.indexOf(node); i < queue.size(); i++) {
            System.out.print(queue.get(i)+"-");
        }
        System.out.println();
    }


}
