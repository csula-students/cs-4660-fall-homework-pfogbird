package csula.cs4660.games;

import csula.cs4660.games.models.MiniMaxState;
import csula.cs4660.graphs.Graph;
import csula.cs4660.graphs.Node;

public class AlphaBeta {
    public static Node getBestMove(Graph graph, Node source, Integer depth, Integer alpha, Integer beta, Boolean max) {
        // TODO: implement your alpha beta pruning algorithm here

        Integer bestValue;
        Integer index = null;
        MiniMaxState currState;

        Node<MiniMaxState> move;
        if (depth == 0 || graph.neighbors(source) == null) {

            currState = new MiniMaxState(0, (Integer) source.getData());

            move = new Node<>((MiniMaxState) currState);

            return move;
        }

        if (max) {
            bestValue = Integer.MIN_VALUE;
            for (Node currNode: graph.neighbors(source)) {

                currNode = getBestMove(graph, source, depth - 1, alpha, beta, false);
                bestValue = Math.max(bestValue, (Integer) currNode.getData());
                alpha = Math.max(alpha, bestValue);
                index++;

                if (beta <= alpha) {

                    break;

                }

            }
            currState = new MiniMaxState(index, alpha);

            move = new Node<>((MiniMaxState) currState);

            return move;

        }
        else {
            bestValue = Integer.MAX_VALUE;
            for (Node currNode : graph.neighbors(source)) {

                currNode = getBestMove(graph, source, depth - 1, alpha, beta, true);
                bestValue = Math.min(bestValue, (Integer) currNode.getData());
                beta = Math.min(beta, bestValue);
                index++;

                if (beta <= alpha) {

                    break;

                }

            }
            currState = new MiniMaxState(index, beta);

            move = new Node<>((MiniMaxState) currState);

            return move;

        }

    }

}