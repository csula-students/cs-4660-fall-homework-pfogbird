package csula.cs4660.graphs.searches;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Graph;
import csula.cs4660.graphs.Node;

import java.util.*;

/**
 * As name, dijkstra search using graph structure
 */
public class DijkstraSearch implements SearchStrategy {
    @Override
    public List<Edge> search(Graph graph, Node source, Node dist) {


        Queue queue = new LinkedList<Node>();
        ArrayList<Edge> reverse = new ArrayList<Edge>();
        HashMap<Node, Node> nodeTracker = new HashMap<>();
        List<Node> accumulator = new ArrayList<>();
        ArrayList<Edge> resultEdges = new ArrayList<Edge>();
        Edge edge = null;
        Integer distance = null;
        Node end = null;

        queue.add(source);

        for (Node node : graph.neighbors(source)) {

            if (!node.equals(source)) {

                distance = graph.distance(source, node);

            }
            queue.add(node);
        }

        while(!queue.isEmpty()) {

            Node current = (Node) queue.poll();

            for (Node node : graph.neighbors(current)) {

                if (!accumulator.contains(node)) {

                    nodeTracker.put(node, current);

                    if (distance < graph.distance(node, current)) {

                        distance = graph.distance(node, current);
                        edge = new Edge(node, current, graph.distance(node, current));

                        queue.poll();

                        resultEdges.add(edge);

                        int temp = resultEdges.size();

                        for (int i = 0; i < resultEdges.size(); i++) {

                            reverse.add(resultEdges.get(temp));
                            temp--;

                        }

                    }

                }

            }

        }

        return reverse;
    }
}