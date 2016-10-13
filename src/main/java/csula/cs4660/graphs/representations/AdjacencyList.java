package csula.cs4660.graphs.representations;

<<<<<<< HEAD
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Node;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.*;
=======
import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Node;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
>>>>>>> 808e64f7f416e6a7be304c2d5d49ae1069290414

/**
 * Adjacency list is probably the most common implementation to store the unknown
 * loose graph
 *
 * TODO: please implement the method body
 */
public class AdjacencyList implements Representation {
<<<<<<< HEAD


    private Map<Node, List<Edge>> adjacencyList;
    //private Multimap<Node, Edge> multiMap = ArrayListMultimap.create();
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

                Node fromNode = new Node(Integer.parseInt(members[0]));
                Node toNode = new Node(Integer.parseInt(members[1]));

                nodes.add(fromNode);
                nodes.add(toNode);
                Edge edge = new Edge(fromNode,toNode,weight);

                addEdge(edge);

            }

        }
        catch(FileNotFoundException e) {
            System.out.println("There was an error.");
        }

    }

    protected AdjacencyList() {
        adjacencyList = new HashMap<>();
=======
    private Map<Node, Collection<Edge>> adjacencyList;

    protected AdjacencyList(File file) {
    }

    protected AdjacencyList() {

>>>>>>> 808e64f7f416e6a7be304c2d5d49ae1069290414
    }

    @Override
    public boolean adjacent(Node x, Node y) {
<<<<<<< HEAD
        boolean result = false;

        for (Edge e: adjacencyList.get(x)) {

            result = result || e.getTo().equals(y);

        }

        return result;
    }

    @Override
    public ArrayList<Node> neighbors(Node x) {
        if (!adjacencyList.containsKey(x)) {
            return new ArrayList<>();
        }

        List<Node> result = new ArrayList<>();




=======
        return false;
    }

    @Override
    public List<Node> neighbors(Node x) {
>>>>>>> 808e64f7f416e6a7be304c2d5d49ae1069290414
        return null;
    }

    @Override
    public boolean addNode(Node x) {
<<<<<<< HEAD



=======
>>>>>>> 808e64f7f416e6a7be304c2d5d49ae1069290414
        return false;
    }

    @Override
    public boolean removeNode(Node x) {
<<<<<<< HEAD



=======
>>>>>>> 808e64f7f416e6a7be304c2d5d49ae1069290414
        return false;
    }

    @Override
    public boolean addEdge(Edge x) {
<<<<<<< HEAD

        if(adjacencyList.containsKey(x.getFrom())) {
            if(adjacencyList.get(x.getFrom()).contains(x)){
                return false;
            }
            adjacencyList.get(x.getFrom()).add(x);
        }
        else {
            adjacencyList.put(x.getFrom(), Lists.newArrayList(x));
        }

        return true;
=======
        return false;
>>>>>>> 808e64f7f416e6a7be304c2d5d49ae1069290414
    }

    @Override
    public boolean removeEdge(Edge x) {
<<<<<<< HEAD

        return adjacencyList.get(x.getFrom()).remove(x);

=======
        return false;
>>>>>>> 808e64f7f416e6a7be304c2d5d49ae1069290414
    }

    @Override
    public int distance(Node from, Node to) {
<<<<<<< HEAD

        int distance = 0;

        for (Edge e: edges) {
            if (from.equals(e.getFrom()) && to.equals(e.getTo())) {
                distance = e.getValue();

                return distance;
            }
        }

        return distance;
=======
        return 0;
>>>>>>> 808e64f7f416e6a7be304c2d5d49ae1069290414
    }

    @Override
    public Optional<Node> getNode(int index) {
<<<<<<< HEAD



        return null;
    }
}
=======
        return null;
    }
}
>>>>>>> 808e64f7f416e6a7be304c2d5d49ae1069290414
