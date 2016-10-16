package csula.cs4660.graphs.searches;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Graph;
import csula.cs4660.graphs.Node;

import java.util.*;

/**
 * Breadth first search
 */
public class BFS implements SearchStrategy {

    @Override
    public ArrayList<Edge> search(Graph graph, Node source, Node dist) {

        Queue queue = new LinkedList<Node>();
        ArrayList<Node> result = new ArrayList<Node>();
        HashMap<Node, Node> nodeTracker = new HashMap<>();
        List<Node> accumulator = new ArrayList<>();
        ArrayList<Edge> resultEdges = new ArrayList<Edge>();

        Node end = null;

        queue.add(source);

        while(!queue.isEmpty()) {
            Node current = (Node)queue.poll();

            for (Node node: graph.neighbors(current)) {

                if(!accumulator.contains(node)) {

                    nodeTracker.put(node, current);

                    if (graph.equals(dist)) {

                        end = new Node(node.getData());

                    }
                    else if (!result.contains(node)) {

                        queue.add(node);
                        result.add(node);
                        nodeTracker.put(node, current);

                    }
                    queue.add(node);
                    accumulator.add(node);

                }

            }

        }

        while (!end.equals(source)) {

            Node parent = nodeTracker.get(end);
            Edge edge = new Edge(parent, end, graph.distance(parent, end));
            resultEdges.add(edge);
            end = parent;

        }

        ArrayList<Edge> reverse = new ArrayList<Edge>();

        int temp = resultEdges.size();

        for (int i = 0; i < resultEdges.size(); i++) {

            reverse.add(resultEdges.get(temp));
            temp--;

        }

        return reverse;
    }

}