package csula.cs4660.graphs.representations;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Object oriented representation of graph is using OOP approach to store nodes
 * and edges
 *
 * TODO: Please fill the body of methods in this class
 */
public class ObjectOriented implements Representation {

    private List<Node> nodes;
    private List<Edge> edges;


    protected ObjectOriented(File file) {

        nodes = new ArrayList<>();
        edges = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String [] members = line.split(":");
                int weight = Integer.parseInt(members[2]);

                Node fromNode = new Node(Integer.parseInt(members[0]));
                Node toNode = new Node(Integer.parseInt(members[1]));


                nodes.add(fromNode);
                nodes.add(toNode);

            }
        } catch (FileNotFoundException e) {

            System.out.println("There was an error.");

        }

    }

    protected ObjectOriented() {

        nodes = new ArrayList<>();
        edges = new ArrayList<>();

    private Collection<Node> nodes;
    private Collection<Edge> edges;

    public ObjectOriented(File file) {
    }

    public ObjectOriented() {


    }

    @Override
    public boolean adjacent(Node x, Node y) {


        for(Edge edge: edges){
            if(edge.getFrom().equals(x) && edge.getTo().equals(y)){
                return true;
            }
        }


        return false;
    }

    @Override
    public List<Node> neighbors(Node x) {


        ArrayList<Node> neighborNodes = new ArrayList<>();

        for (Edge e: edges) {

            neighborNodes.add(e.getTo());

        }

        return neighborNodes;

        return null;

    }

    @Override
    public boolean addNode(Node x) {


        if(nodes.contains(x)){
            return false;
        }

        nodes.add(x);

        return true;

    }

    @Override
    public boolean removeNode(Node x) {

        if(!nodes.contains(x)){
            return false;
        }

        for (Edge e: edges) {

            if (e.getTo().equals(x) || e.getFrom().equals(x)) {
                edges.remove(x);
            }

        }

        return nodes.remove(x);

        return false;

    }

    @Override
    public boolean addEdge(Edge x) {


        if(!nodes.contains(x.getFrom())){
            nodes.add(x.getFrom());
        }

        if(!nodes.contains(x.getTo())){
            nodes.add(x.getTo());
        }

        if (edges.contains(x)) {
            return false;
        }

        edges.add(x);

       return true;

        return false;

    }

    @Override
    public boolean removeEdge(Edge x) {




        return edges.remove(x);
    }

    @Override
    public int distance(Node from, Node to) {


        int distance = 0;

        for (Edge e: edges) {
            if (e.getFrom().equals(from) && e.getTo().equals(to)) {
                distance = e.getValue();
                return distance;
            }
        }

        return distance;
}

    @Override
    public Optional<Node> getNode(int index) {



        return null;
    }
}

        return 0;
    }

    @Override
    public Optional<Node> getNode(int index) {
        return null;
    }
}

