import java.util.ArrayList;
import java.util.Random;

public class Board {

    //private final Coordinate boardDim;
    private static final int BOARD_SIZE = 30;
    private Cell[][] board = new Cell[BOARD_SIZE][BOARD_SIZE];
    //private final Coordinate boardDim;
    //private final Cell[][] board;
    // Board(String testing) is used for test purposes

    public Board(String testing) {
        //Mark all spots as BLANK in the center and WALL on the borders
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (i == 0 || i == 10 || j == 0 || j == 10) {
                    this.board[i][j] = Cell.WALL;
                } else {
                    this.board[i][j] = Cell.BLANK;
                }
            }
        }

        // Puts Head and Food at the center next to each other
        this.board[5][5] = Cell.HEAD;
        //this.board[5][6] = Cell.FOOD;
    }

    /*public Board(Coordinate boardDim){
        this.boardDim = boardDim;
        this.board = new Cell[boardDim.getX()][boardDim.getY()];
    }*/

    public Board() {
        //Mark all spots as BLANK in the center and WALL on the borders
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (i == 0 || i == BOARD_SIZE - 1 || j == 0 || j == BOARD_SIZE - 1) {
                    this.board[i][j] = Cell.WALL;
                } else {
                    this.board[i][j] = Cell.BLANK;
                }
            }
        }

        //Place the snake's head in a random spot
        Random rng = new Random();
        int colHead = rng.nextInt((BOARD_SIZE - 2)) + 1; //random number between 1 and 9, i.e. non-Wall cells
        int rowHead = rng.nextInt((BOARD_SIZE - 2)) + 1;
        this.board[rowHead][colHead] = Cell.HEAD;

        //Place the food in an empty random spot
        regenerateFood();

           }

    public void regenerateFood(){
        // Get the current food position
        Coordinate oldFoodPosition = getCoordinateFood();
        //Place the food in an empty random spot
        Random rng = new Random();
        int random_i_for_food = rng.nextInt((BOARD_SIZE - 2)) + 1;
        int random_j_for_food = rng.nextInt((BOARD_SIZE - 2)) + 1;
        while (this.board[random_i_for_food][random_j_for_food] != Cell.BLANK ||
                (random_i_for_food == oldFoodPosition.getY() && random_j_for_food == oldFoodPosition.getX()))  {
            random_i_for_food = rng.nextInt((BOARD_SIZE - 2)) + 1;
            random_j_for_food = rng.nextInt((BOARD_SIZE - 2)) + 1;
        }
        this.board[random_i_for_food][random_j_for_food] = Cell.FOOD;
    }

    /*public Coordinate getBoardDim(){
        return this.boardDim;
    }*/

    public static int getBoardSize() {
        return BOARD_SIZE;
    }

    public Cell[][] getBoard() {
        return this.board;
    }

    public Cell getCell(int i, int j) {
        return board[i][j];
    }

    public Cell getCell(Coordinate coord) {
        return board[coord.getY()][coord.getX()];
    }

    public void setCell(int i, int j, Cell cellContentToPut) {

        board[i][j] = cellContentToPut;

    }

    public void setCell(Coordinate coord, Cell cellContentToPut) {
        board[coord.getY()][coord.getX()] = cellContentToPut;
    }

    public Coordinate getCoordinateHead() {
        for (int i = 0; i < Board.getBoardSize(); i++) {
            for (int j = 0; j < Board.getBoardSize(); j++) {
                if (this.getCell(i, j) == Cell.HEAD) {
                    return new Coordinate(i,j);
                }
            }
        }
        return new Coordinate(-1,-1);  // error case
    }

    public Coordinate getCoordinateFood() {
        for (int i = 0; i < Board.getBoardSize(); i++) {
            for (int j = 0; j < Board.getBoardSize(); j++) {
                if (this.getCell(i, j) == Cell.FOOD) {
                    return new Coordinate(i,j);
                }
            }
        }
        return new Coordinate(-1,-1);  // error case
    }

}
