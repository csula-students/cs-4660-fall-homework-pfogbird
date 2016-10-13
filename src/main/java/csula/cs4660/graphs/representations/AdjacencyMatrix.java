package csula.cs4660.graphs.representations;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Node;

import java.io.File;
<<<<<<< HEAD
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Scanner;

=======
import java.util.List;
import java.util.Optional;
>>>>>>> 808e64f7f416e6a7be304c2d5d49ae1069290414

/**
 * Adjacency matrix in a sense store the nodes in two dimensional array
 *
 * TODO: please fill the method body of this class
 */
public class AdjacencyMatrix implements Representation {
    private Node[] nodes;
    private int[][] adjacencyMatrix;

<<<<<<< HEAD
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
=======
    public AdjacencyMatrix(File file) {
    }

    public AdjacencyMatrix() {

>>>>>>> 808e64f7f416e6a7be304c2d5d49ae1069290414
    }

    @Override
    public boolean adjacent(Node x, Node y) {
<<<<<<< HEAD



=======
>>>>>>> 808e64f7f416e6a7be304c2d5d49ae1069290414
        return false;
    }

    @Override
    public List<Node> neighbors(Node x) {
<<<<<<< HEAD



=======
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



=======
>>>>>>> 808e64f7f416e6a7be304c2d5d49ae1069290414
        return false;
    }

    @Override
    public boolean removeEdge(Edge x) {
<<<<<<< HEAD



=======
>>>>>>> 808e64f7f416e6a7be304c2d5d49ae1069290414
        return false;
    }

    @Override
    public int distance(Node from, Node to) {
<<<<<<< HEAD



=======
>>>>>>> 808e64f7f416e6a7be304c2d5d49ae1069290414
        return 0;
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
