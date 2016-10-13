package csula.cs4660.graphs.representations;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Adjacency matrix in a sense store the nodes in two dimensional array
 *
 * TODO: please fill the method body of this class
 */
public class AdjacencyMatrix implements Representation {
    private Node[] nodes;
    private int[][] adjacencyMatrix;

    protected AdjacencyMatrix(File file) {

        try{
            Scanner scanner = new Scanner(file);
            int size = Integer.parseInt(scanner.nextLine());

            nodes = new Node[size];


            adjacencyMatrix = new int[size][size];

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

            }


        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }

    protected AdjacencyMatrix() {
        nodes = new Node[0];
        adjacencyMatrix = new int[0][0];
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