import java.util.Random;

public class Board {
    private static final int BOARD_SIZE = 9;

    private Character[][] board = new Character[BOARD_SIZE][BOARD_SIZE];
    // For now, H = Head of snake, S = Body of snake, F = Food, O = Void cell
    // Later on we could make a Cell class if we need a finer implementation.

    public Board() {
        //Mark all spots as empty
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                this.board[i][j] = 'O';
            }
        }

        //Place the snake's head in a random spot
        Random rng = new Random();
        int colHead = rng.nextInt(BOARD_SIZE);
        int rowHead = rng.nextInt(BOARD_SIZE);
        this.board[rowHead][colHead] = 'H';

        //Place the food in an empty random spot
        int random_i_for_food = rng.nextInt(BOARD_SIZE);
        int random_j_for_food = rng.nextInt(BOARD_SIZE);
        while (this.board[random_i_for_food][random_j_for_food] != 'O') {
            random_i_for_food = rng.nextInt(BOARD_SIZE);
            random_j_for_food = rng.nextInt(BOARD_SIZE);
        }
        this.board[random_i_for_food][random_j_for_food] = 'F';

    }

    public static int getBoardSize() {
        return BOARD_SIZE;
    }

    public Character[][] getBoard() {
        return board;
    }

    public Character getCell(int i, int j) {
        return board[i][j];
    }

    public void setCell(int i, int j, Character charToPutInCell) {
        board[i][j] = charToPutInCell;
    }

    public int[] getRowColHead() {
        for (int i = 0; i < Board.getBoardSize(); i++) {
            for (int j = 0; j < Board.getBoardSize(); j++) {
                if (this.getCell(i, j) == 'H') {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};  // error case
    }

}
