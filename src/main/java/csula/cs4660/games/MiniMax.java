package csula.cs4660.games;

import csula.cs4660.games.models.MiniMaxState;
import csula.cs4660.graphs.Graph;
import csula.cs4660.graphs.Node;

public class MiniMax {
    public static Node getBestMove(Graph graph, Node root, Integer depth, Boolean max) {
        // TODO: implement minimax to retrieve best move
        // NOTE: you should mutate graph and node as you traverse and update value

        Integer bestValue;
        Integer index = null;
        MiniMaxState currState;

        Node<MiniMaxState> move;

        if (depth == 0 || graph.neighbors(root) == null) {

            currState = new MiniMaxState(0, (Integer) root.getData());

            move = new Node<>(currState);

            return move;
        }

        if (max) {
            bestValue = Integer.MIN_VALUE;

            for (Node currNode : graph.neighbors(root)) {

                currNode = getBestMove(graph, root, depth - 1, false);
                bestValue = Math.max(bestValue, (Integer) currNode.getData());
                index++;

            }
            currState = new MiniMaxState(index, bestValue);

            move = new Node<>(currState);

            return move;

        } else {
            bestValue = Integer.MAX_VALUE;

            for (Node currNode : graph.neighbors(root)) {

                currNode = getBestMove(graph, root, depth - 1, true);
                bestValue = Math.min(bestValue, (Integer) currNode.getData());
                index++;

            }
            currState = new MiniMaxState(index, bestValue);

            move = new Node<>(currState);

            return move;

        }

    }

}
