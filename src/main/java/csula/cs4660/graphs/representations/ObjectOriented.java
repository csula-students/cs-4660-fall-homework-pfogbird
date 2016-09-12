package csula.cs4660.graphs.representations;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

/**
 * Object oriented representation of graph is using OOP approach to store nodes
 * and edges
 *
 * TODO: Please fill the body of methods in this class
 */
public class ObjectOriented implements Representation {
    //private Collection<Node> nodes = new ArrayList<>();
    //private Collection<Edge> edges = new ArrayList<>();
    private ArrayList<Node> nodes = new ArrayList<>();
    private ArrayList<Edge> edges = new ArrayList<>();
    private HashMap<Node, ArrayList<Edge>> graphNetwork = new HashMap<>();

    public ObjectOriented(File file) {

        if(file.exists()) {
            System.out.println("File exists.");
        }
        else {
            System.out.println("File ain't there.");
        }

        try {
            Scanner input = new Scanner(file);
            String [] members;
            String line = input.nextLine();

            int numNodes = Integer.parseInt(line);

            graphNetwork = new HashMap<>();

            //Node newNode = new Node(numNodes);
            //nodes.add(newNode);

        /*    for (int i = 0; i < numNodes; i++) {

                Node temp = new Node(i);
                graphNetwork.put(temp, edges);

            }     */

            while (input.hasNextLine()) {

                line = input.nextLine();
                members = line.split(":");
                int weight = Integer.parseInt(members[2]);

                Node fromNode = new Node(members[0]);
                Node toNode = new Node(members[1]);

                Edge newEdge = new Edge(fromNode,toNode,weight);
                edges.add(newEdge);
                System.out.println("Hey there ");

                graphNetwork.put(fromNode, edges);

            }
            //System.out.println("Testing");
            System.out.println("Values" + graphNetwork.values());

        } catch (FileNotFoundException e) {

            System.out.println("There was an error.");

        }


    }

    public ObjectOriented() {

    }

    @Override
    public boolean adjacent(Node x, Node y) {



        return false;
    }

    @Override
    public List<Node> neighbors(Node x) {



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



        return false;
    }

    @Override
    public int distance(Node from, Node to) {



        return 0;
    }

    @Override
    public Optional<Node> getNode(int index) {



        return null;
    }
}
