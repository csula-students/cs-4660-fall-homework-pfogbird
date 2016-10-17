package csula.cs4660.quizes;

import csula.cs4660.graphs.Node;
import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Graph;
import csula.cs4660.graphs.searches.DijkstraSearch;
import csula.cs4660.graphs.searches.BFS;

import csula.cs4660.quizes.models.State;

import java.util.*;

/**
 * Here is your quiz entry point and your app
 */
public class App {

    public static void main(String[] args) {
        // to get a state, you can simply call `Client.getState with the id`
        State initialState = Client.getState("10a5461773e8fd60940a56d2e9ef7bf4").get();
        System.out.println(initialState);
        // to get an edge between state to its neighbor, you can call stateTransition
        System.out.println(Client.stateTransition(initialState.getId(), initialState.getNeighbors()[0].getId()));


        State finalState = Client.getState("e577aa79473673f6158cc73e0e5dc122").get();
        System.out.println(finalState);

        System.out.println(Client.stateTransition(finalState.getId(), finalState.getNeighbors()[1].getId()));

        BFS(initialState, finalState);
        Dijkstra(initialState, finalState);

    }

    public static void BFS(State initialState, State finalState) {

        Queue<State> queue = new LinkedList<>();
        Set<State> visitedStates = new HashSet<>();
        Map<State, State> parentStates = new HashMap<>();

        queue.add(initialState);
        visitedStates.add(initialState);

        while (!queue.isEmpty()) {
            State currentState = queue.poll();
            visitedStates.add(currentState);

            for (State state: Client.getState(currentState.getId()).get().getNeighbors()) {
                if (state.getId().equals("e577aa79473673f6158cc73e0e5dc122")) {

                    System.out.println("Path weight = " + discoveredPath(parentStates, currentState, initialState));

                    System.out.print(currentState);

                }
                else if (!visitedStates.contains(state)) {

                    parentStates.put(state, currentState);
                    queue.add(state);

                }

            }

        }

    }

    public static void Dijkstra(State initialState, State finalState) {
        Queue<State> queue = new LinkedList<>();
        Set<State> visitedStates = new HashSet<>();
        Map<State, State> parentStates = new HashMap<>();

        queue.add(initialState);
        visitedStates.add(initialState);


        while (!queue.isEmpty()) {
            State currentState = queue.poll();
            for (State state : Client.getState(currentState.getId()).get().getNeighbors()) {

                if (state.equals(currentState)) {

                    System.out.println("Path weight = " + discoveredPath(parentStates, currentState, initialState));
                    System.out.println(currentState);
                    queue.add(state);
                    visitedStates.add(state);

                    if (!visitedStates.contains(state)) {

                        parentStates.put(state, currentState);

                        System.out.println("Path weight = " + discoveredPath(parentStates, currentState, initialState));
                        System.out.println(currentState);

                    }

                }

            }

        }


    }

    public static Integer discoveredPath(Map<State, State> parentStates, State currentState, State initialState) {

        Integer pathWeight = 0;

        State tempState = currentState;

        while (!tempState.equals(initialState)) {

            pathWeight++;
            tempState = parentStates.get(tempState);

        }

        return pathWeight;
    }

}
