package csula.cs4660.graphs.representations;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Node;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.*;

/**
 * Adjacency list is probably the most common implementation to store the unknown
 * loose graph
 *
 * TODO: please implement the method body
 */
public class AdjacencyList implements Representation {
    private Map<Node, List<Edge>> adjacencyList;
    private Multimap<Node, Edge> multiMap = ArrayListMultimap.create();
    private ArrayList<Node> nodes = new ArrayList<>();
    private ArrayList<Edge> edges = new ArrayList<>();

    public AdjacencyList(File file) {
        try {
            Scanner scanner = new Scanner(file);
            String [] members;
            String line = scanner.nextLine();

            while (scanner.hasNextLine()) {

                line = scanner.nextLine();
                members = line.split(":");
                int weight = Integer.parseInt(members[2]);

                Node fromNode = new Node(members[0]);
                Node toNode = new Node(members[1]);

                nodes.add(fromNode);
                nodes.add(toNode);
                Edge edge = new Edge(fromNode,toNode,weight);

                multiMap.put(fromNode, edge);

            }

        }
        catch(FileNotFoundException e) {
            System.out.println("There was an error.");
        }

    }

    protected AdjacencyList() {
        adjacencyList = new HashMap<>();
    }

    @Override
    public boolean adjacent(Node x, Node y) {


        return false;
    }

    @Override
    public ArrayList<Node> neighbors(Node x) {



        return null;
    }

    @Override
    public boolean addNode(Node x) {


        return false;
    }

    @Override
    public boolean removeNode(Node x) {


        return false;
    }

    @Override
    public boolean addEdge(Edge x) {



        return false;
    }

    @Override
    public boolean removeEdge(Edge x) {

        return adjacencyList.get(x.getFrom()).remove(x);

    }

    @Override
    public int distance(Node from, Node to) {

        int distance = 0;

        for (Edge e: edges) {
            if (from.equals(e.getFrom()) && to.equals(e.getTo())) {
                distance = e.getValue();
                System.out.println(distance);
            }
        }

        return distance;
    }

    @Override
    public Optional<Node> getNode(int index) {



        return null;
    }
}