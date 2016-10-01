package csula.cs4660.graphs.representations;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Optional;

/**
 * Object oriented representation of graph is using OOP approach to store nodes
 * and edges
 *
 * TODO: Please fill the body of methods in this class
 */
public class ObjectOriented implements Representation {

    private ArrayList<Node> nodes = new ArrayList<>();
    private ArrayList<Edge> edges = new ArrayList<>();
    private HashMap<Node, ArrayList<Edge>> graphNetwork = new HashMap<>();

    public ObjectOriented(File file) {

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

                if(!graphNetwork.containsKey(fromNode)) {

                    edges.add(new Edge(fromNode, toNode, weight));
                    graphNetwork.put(fromNode, edges);

                }
                else {

                    edges = graphNetwork.get(fromNode);
                    edges.add(new Edge(fromNode, toNode, weight));

                }

            }

            for (Node n: graphNetwork.keySet()) {

                for (Edge e: graphNetwork.get(n)) {

                    System.out.println(e);

                }

            }

        } catch (FileNotFoundException e) {

            System.out.println("There was an error.");

        }

    }

    public ObjectOriented() {
    }

    @Override
    public boolean adjacent(Node x, Node y) {

        ArrayList<Node> adjacentNodes = new ArrayList<>();

        for (Edge e: graphNetwork.get(x)) {

            adjacentNodes.add(e.getTo());

        }

        for (Edge e: graphNetwork.get(y)) {

            adjacentNodes.add(e.getTo());

        }

        return false;
    }

    @Override
    public List<Node> neighbors(Node x) {

        ArrayList<Node> neighborNodes = new ArrayList<>();

        for (Edge e: graphNetwork.get(x)) {

            neighborNodes.add(e.getTo());

        }

        return neighborNodes;
    }

    @Override
    public boolean addNode(Node x) {
        edges = new ArrayList<>();
        graphNetwork.put(x, edges);

        return graphNetwork.containsKey(x);
    }

    @Override
    public boolean removeNode(Node x) {

        graphNetwork.remove(x);

        return false;
    }

    @Override
    public boolean addEdge(Edge x) {

        Node from = x.getFrom();
        graphNetwork.get(from).add(x);

        if(graphNetwork.get(from).contains(x) == true){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean removeEdge(Edge x) {

        Node from = x.getFrom();
        graphNetwork.get(from).remove(x);


        if(graphNetwork.get(from).contains(x) == true){
            return false;
        }
        else{
            return true;
        }
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