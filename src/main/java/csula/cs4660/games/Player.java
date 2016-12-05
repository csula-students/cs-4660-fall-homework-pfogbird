package csula.cs4660.games;

import java.util.*;


/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    static final Integer numX = 30;
    static final Integer numY = 20;

    static final Integer xMinBound = 0;
    static final Integer xMaxBound = 29;

    static final Integer yMinBound = 0;
    static final Integer yMaxBound = 19;

    static GridBoard grid = new GridBoard(numX, numY);

    static PlayerPosition player1 = new PlayerPosition(0);
    static PlayerPosition player2 = new PlayerPosition(1);

    static PlayerPosition myPlayer;
    static PlayerPosition opponent;


    static ArrayList<PlayerPosition> players = new ArrayList<>();

    static Map<Integer, Integer> bfsPath = new LinkedHashMap<>();
    static Map<Integer, Integer> dfsPath = new LinkedHashMap<>();


    static final String[] directions = {"UP", "DOWN", "LEFT", "RIGHT"};

    public static void main(String args[]) {
        String move;

        players.add(myPlayer);
        players.add(opponent);

        fillBoard(grid);

        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            int N = in.nextInt(); // total number of players (2 to 4).
            int P = in.nextInt(); // your player number (0 to 3).

            if (player1.equals(myPlayer(P, player1)) && player2.equals(notMyPlayer(P, player2))) {

                myPlayer.equals(new PlayerPosition(player1));
                opponent.equals(new PlayerPosition(player2));

            }
            else if (player2.equals(myPlayer(P, player2)) && player1.equals(notMyPlayer(P, player1))) {

                myPlayer.equals(new PlayerPosition(player2));
                opponent.equals(new PlayerPosition(player1));

            }


            for (int i = 0; i < N; i++) {
                int X0 = in.nextInt(); // starting X coordinate of lightcycle (or -1)
                int Y0 = in.nextInt(); // starting Y coordinate of lightcycle (or -1)
                int X1 = in.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
                int Y1 = in.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)


                if (i == P) {

                    myPlayer.setXStart(X0);
                    myPlayer.setXCurr(X1);
                    myPlayer.setYStart(Y0);
                    myPlayer.setYCurr(Y1);

                    grid.grid[myPlayer.getXStart()][myPlayer.getYStart()] = 1;
                    grid.grid[myPlayer.getXCurr()][myPlayer.getYCurr()] = 1;

                }
                else if (i != P) {

                    opponent.setXStart(X0);
                    opponent.setXCurr(X1);
                    opponent.setYStart(Y0);
                    opponent.setYCurr(Y1);

                    grid.grid[opponent.getXStart()][opponent.getYStart()] = 2;
                    grid.grid[opponent.getXCurr()][opponent.getYCurr()] = 2;

                }

                System.err.println("my player");
                System.err.println(myPlayer.getXStart());
                System.err.println(myPlayer.getYStart());
                System.err.println(myPlayer.getXCurr());
                System.err.println(myPlayer.getYCurr());

                System.err.println();

                System.err.println("opponent");
                System.err.println(opponent.getXStart());
                System.err.println(opponent.getYStart());
                System.err.println(opponent.getXCurr());
                System.err.println(opponent.getYCurr());

                System.err.println();


            }



            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            System.out.println("LEFT"); // A single line with UP, DOWN, LEFT or RIGHT
        }

    }

    //depth and breadth first search

    public static Map<Integer, Integer> DFS(PlayerPosition currPlayer) {
        Map<Integer, Integer> openPath = new LinkedHashMap<>();



        return openPath;
    }


    public static Map<Integer, Integer> BFS(PlayerPosition currPlayer) {
        Map<Integer, Integer> openPath = new LinkedHashMap<>();



        return openPath;
    }


    public boolean aboutToCrash(PlayerPosition player, PlayerPosition opponent) {
        boolean aboutToCrash = false;



        return aboutToCrash;
    }

    public static String whatStrategyToUse(PlayerPosition player, PlayerPosition opponent){
        String stratgey = null;



        return stratgey;
    }

    //MonteCarlo
    public static String monteCarlo(PlayerPosition player, PlayerPosition opponent) {
        String move = null;



        return move;
    }


    //MINIMAX
    public static String miniMax(PlayerPosition player, PlayerPosition opponent){
        String move = null;



        return move;
    }

    //flood fill, wall hugging
    public static String floodFill(PlayerPosition player, PlayerPosition opponent) {
        String move = null;



        return move;
    }

    public static String wallHug(PlayerPosition player){
        String move = null;

        if (player.xPosCurr == xMinBound) {
            move = directions[3]; //right
        }
        else if (player.xPosCurr == xMaxBound) {
            move = directions[2]; //left
        }
        else if (player.yPosCurr == yMinBound) {
            move = directions[1]; //down
        }
        else if (player.yPosCurr == yMaxBound) {
            move = directions[0]; //up
        }

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

    public static boolean isEmpty(Integer xPos, Integer yPos){
        boolean isEmpty = false;

        if (grid.grid[xPos][yPos] == 0){
            isEmpty = true;
        }
        else if (grid.grid[xPos][yPos] != 0) {
            isEmpty = false;
        }

        return isEmpty;
    }

    public static boolean isTaken(Integer xPos, Integer yPos) {
        boolean isTaken = false;

        if (grid.grid[xPos][yPos] != 0){
            isTaken = true;
        }
        else if (grid.grid[xPos][yPos] == 0) {
            isTaken = false;
        }

        return isTaken;
    }

    public static void fillBoard(GridBoard grid){

        for (int i = 0; i < grid.x; i++) {
            for (int j = 0; j < grid.y; j++) {
                grid.grid[i][j] = 0;
            }
        }

    }

    public static void printBoard(GridBoard grid){

        for (int i = 0; i < grid.x; i++) {
            for (int j = 0; j < grid.y; j++) {
                System.err.println(grid.grid[i][j]);
            }
            System.err.println();
        }

    }

}


class GridBoard {

    Integer grid[][];
    Integer x;
    Integer y;

    public GridBoard() {}

    public GridBoard(GridBoard grid){

        this(grid.getGrid(), grid.getX(), grid.getY());

    }

    public GridBoard(Integer x, Integer y) {

        super();
        this.x = x;
        this.y = y;
        this.grid = new Integer [this.x][this.y];

    }

    public GridBoard(Integer[][] grid, Integer x, Integer y) {

        super();
        this.grid = grid;
        this.x = x;
        this.y = y;

    }

    public Integer[][] getGrid(){

        return grid;
    }

    public Integer getX(){

        return x;
    }

    public Integer getY(){

        return y;
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