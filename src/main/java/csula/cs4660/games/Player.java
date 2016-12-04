package csula.cs4660.games;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    static final Integer numRows = 20;
    static final Integer numCols = 30;
    static final Integer rowMinBound = 0;
    static final Integer rowMaxBound = 19;
    static final Integer colMinBound = 0;
    static final Integer colMaxBound = 29;

    static GridBoard grid = new GridBoard(numRows, numCols);

    static PlayerPosition player1 = new PlayerPosition(0);
    static PlayerPosition player2 = new PlayerPosition(1);

    static PlayerPosition myPlayer = null;
    static PlayerPosition opponent = null;

    static ArrayList<PlayerPosition> players = new ArrayList<>();

    public static void main(String args[]) {
        String move = "LEFT";

        players.add(player1);
        players.add(player2);

        fillBoard(grid);

        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            int N = in.nextInt(); // total number of players (2 to 4).
            int P = in.nextInt(); // your player number (0 to 3).

            for (int i = 0; i < N; i++) {
                int X0 = in.nextInt(); // starting X coordinate of lightcycle (or -1)
                int Y0 = in.nextInt(); // starting Y coordinate of lightcycle (or -1)
                int X1 = in.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
                int Y1 = in.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)

                if (i == 0) {

                    player1.setXStart(X0);
                    player1.setXCurr(X1);
                    player1.setYStart(Y0);
                    player1.setYCurr(Y1);

                }
                else if (i == 1) {

                    player2.setXStart(X0);
                    player2.setXCurr(X1);
                    player2.setYStart(Y0);
                    player2.setYCurr(Y1);

                }


                grid.grid[X0][Y0] = 1;
                grid.grid[X1][Y1] = 1;

            }

            if (player1.equals(myPlayer(P, player1)) && player2.equals(notMyPlayer(P, player2))) {

                myPlayer = new PlayerPosition(player1);
                opponent = new PlayerPosition(player2);

            }
            else if (player2.equals(myPlayer(P, player2)) && player1.equals(notMyPlayer(P, player1))) {

                myPlayer = new PlayerPosition(player2);
                opponent = new PlayerPosition(player1);

            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");



            System.out.println("LEFT"); // A single line with UP, DOWN, LEFT or RIGHT
        }

    }

    /*Depth and breath first search

    public static void DFS(){


    }


    public static void BFS(){


    }


    */

    public boolean aboutToCrash(GridBoard gameBoard, PlayerPosition player, PlayerPosition opponent) {
        boolean aboutToCrash = false;



        return aboutToCrash;
    }

    public static String whatStrategyToUse(GridBoard gameBoard, PlayerPosition player, PlayerPosition opponent){
        String stratgey = null;



        return stratgey;
    }

    //MonteCarlo
    public static String monteCarlo(GridBoard gameBoard, PlayerPosition player, PlayerPosition opponent) {
        String move = null;



        return move;
    }


    //MINIMAX
    public static String miniMax(GridBoard gameBoard, PlayerPosition player, PlayerPosition opponent){
        String move = null;



        return move;
    }

    //flood fill, wall hugging
    public static String floodFill(GridBoard gameBoard, PlayerPosition player, PlayerPosition opponent) {
        String move = null;



        return move;
    }

    public static String wallHug(GridBoard gameBoard, PlayerPosition player, PlayerPosition opponent){
        String move = null;



        return move;
    }

    public static PlayerPosition myPlayer(Integer myPlayerId, PlayerPosition currPlayer) {

        if (myPlayerId == currPlayer.playerId) {
            return currPlayer;
        }
        else{
            return null;
        }

    }

    public static PlayerPosition notMyPlayer(Integer myPlayerId, PlayerPosition currPlayer) {

        if (myPlayerId != currPlayer.playerId) {
            return currPlayer;
        }
        else{
            return null;
        }

    }

    public static boolean isEmpty(GridBoard currGrid, Integer xPos, Integer yPos){
        boolean isEmpty = false;

        if (currGrid.grid[xPos][yPos] == 0){
            isEmpty = true;
        }
        else if (currGrid.grid[xPos][yPos] != 0) {
            isEmpty = false;
        }

        return isEmpty;
    }

    public static boolean isTaken(GridBoard currGrid, Integer xPos, Integer yPos) {
        boolean isTaken = false;

        if (currGrid.grid[xPos][yPos] != 0){
            isTaken = true;
        }
        else if (currGrid.grid[xPos][yPos] == 0) {
            isTaken = false;
        }

        return isTaken;
    }

    public static void fillBoard(GridBoard currGrid){

        for (int i = 0; i < currGrid.row; i++) {
            for (int j = 0; j < currGrid.col; j++) {
                currGrid.grid[i][j] = 0;
            }
        }

    }

}


class GridBoard {

    Integer grid[][];
    Integer row;
    Integer col;

    public GridBoard() {}

    public GridBoard(GridBoard grid){

        this(grid.getGrid(), grid.getRow(), grid.getCol());

    }

    public GridBoard(Integer row, Integer col) {

        super();
        this.row = row;
        this.col = col;
        this.grid = new Integer [this.row][this.col];

    }

    public GridBoard(Integer[][] grid, Integer row, Integer col) {

        super();
        this.grid = grid;
        this.row = row;
        this.col = col;

    }

    public Integer[][] getGrid(){

        return grid;
    }

    public Integer getRow(){

        return row;
    }

    public Integer getCol(){

        return col;
    }

}



class PlayerPosition {

    Integer playerId;
    Integer xPosCurr;
    Integer yPosCurr;
    Integer xPosStart;
    Integer yPosStart;

    public PlayerPosition(){}

    public PlayerPosition(Integer playerId){

        super();
        this.playerId = playerId;

    }

    public PlayerPosition(PlayerPosition playerArg) {

        this(playerArg.getPlayerId(), playerArg.getXCurr(), playerArg.getXStart(), playerArg.getYCurr(), playerArg.getYStart());
    }

    public PlayerPosition(Integer playerId, Integer xPosStart, Integer yPosStart){

        super();
        this.playerId = playerId;
        this.xPosStart = xPosStart;
        this.yPosStart = yPosStart;

    }

    public PlayerPosition(Integer playerId, Integer xPosCurr, Integer xPosStart, Integer yPosCurr, Integer yPosStart) {

        super();
        this.playerId = playerId;
        this.xPosCurr = xPosCurr;
        this.xPosStart = xPosStart;
        this.yPosCurr = yPosCurr;
        this.yPosStart = yPosStart;

    }

    public void setXCurr(Integer xPosCurr) {

        this.xPosCurr = xPosCurr;
    }

    public void setYCurr(Integer yPosCurr) {

        this.yPosCurr = yPosCurr;
    }

    public void setXStart(Integer xPosStart) {

        this.xPosStart = xPosStart;
    }

    public void setYStart(Integer yPosStart) {

        this.yPosStart = yPosStart;
    }

    public Integer getPlayerId() {

        return playerId;
    }

    public Integer getXCurr(){

        return xPosCurr;
    }

    public Integer getYCurr(){

        return yPosCurr;
    }

    public Integer getXStart() {

        return xPosStart;
    }

    public Integer getYStart() {

        return yPosStart;
    }

}