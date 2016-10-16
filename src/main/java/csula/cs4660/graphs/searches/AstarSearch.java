package csula.cs4660.graphs.searches;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Graph;
import csula.cs4660.graphs.Node;

import java.util.*;

/**
 * Perform A* search
 */
public class AstarSearch implements SearchStrategy {

    @Override
    public List<Edge> search(Graph graph, Node source, Node dist) {

        Queue frontier = new LinkedList<Node>();
        HashSet<Node> visited = new HashSet<Node>();
        HashMap<Node, Node> nodeTracker = new HashMap<>();
        List<Edge> resultEdges = new ArrayList<Edge>();

        frontier.add(source);

        Map<Node, Integer> gScore = new HashMap<Node, Integer>();
        gScore.put(source, 0);

        Map<Node, Integer> fScore = new HashMap<Node, Integer>();
        fScore.put(source, graph.distance(source, dist));

        while (!frontier.isEmpty()) {

            Node u = (Node) frontier.poll();

            if (u.equals(dist)) {
                Edge edge = new Edge(u, dist, graph.distance(u, dist));
                resultEdges.add(edge);

                ArrayList<Edge> reverse = new ArrayList<Edge>();

                int temp = resultEdges.size();

                for (int i = 0; i < resultEdges.size(); i++) {

                    reverse.add(resultEdges.get(temp));
                    temp--;

                }

                return reverse;
            }

            visited.add(u);

            for (Node node: graph.neighbors(u)){

                if(visited.contains(node)) {
                    continue;
                }
                Integer tempGScore = gScore.get(u) + graph.distance(u, node);

                if(!frontier.contains(node)) {
                    frontier.add(node);
                }
                else if (tempGScore >=  gScore.get(node)) {
                    continue;
                }

                nodeTracker.put(node, u);
                gScore.put(node, tempGScore);
                fScore.put(node, gScore.get(node)+graph.distance(node, dist));

            }

        }

        return null;
    }

}