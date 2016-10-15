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
    public List<Edge> search(Graph graph, Node source, Node dist) {

        Queue queue = new LinkedList<Node>();
        List<Node> result = new ArrayList<>();
        HashMap<Node, Node> nodeTracker = new HashMap<>();
        List<Node> accumulator = new ArrayList<>();

        Node end;

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

        while () {



        }


        return null;
    }

}
