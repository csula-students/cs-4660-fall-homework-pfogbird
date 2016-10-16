package csula.cs4660.graphs.searches;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Graph;
import csula.cs4660.graphs.Node;

import java.util.*;

/**
 * Depth first search
 */
public class DFS implements SearchStrategy {

    @Override
    public List<Edge> search(Graph graph, Node source, Node dist) {

        Queue queue = new LinkedList<Node>();
        ArrayList<Node> result = new ArrayList<Node>();
        HashMap<Node, Node> nodeTracker = new HashMap<>();
        List<Node> accumulator = new ArrayList<>();
        ArrayList<Edge> resultEdges = new ArrayList<Edge>();
        Edge edge = null;

        Node end = null;

        queue.add(source);

        while (!queue.isEmpty()) {
            Node current = (Node) queue.poll();
            for (Node node : graph.neighbors(current)) {

                if (node.equals(current)) {
                    continue;
                }
                else if (node.equals(dist)) {
                    edge = new Edge(current, dist, graph.distance(current, dist));
                    resultEdges.add(edge);

                    ArrayList<Edge> reverse = new ArrayList<Edge>();

                    int temp = resultEdges.size();

                    for (int i = 0; i < resultEdges.size(); i++) {

                        reverse.add(resultEdges.get(temp));
                        temp--;

                    }

                    return reverse;
                }

                Node child = node;

                nodeTracker.put(current, child);
                edge = new Edge(current, child, graph.distance(current, child));
                resultEdges.add(edge);
                search(graph, current, child);

            }

        }

        return null;
    }

}