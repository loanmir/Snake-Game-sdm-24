public class Board {
    private static final int BOARD_SIZE = 9;
    private Character[][] board = new Character[BOARD_SIZE][BOARD_SIZE];
    // For now, H = Head of snake, S = Body of snake, F = Food, O = Void cell
    // Later on we could make a Cell class if we need a finer implementation.

    public Board() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (i == 0 && j == 0) {
                    this.board[i][j] = 'H';
                } else if (i == 0 && j == 1) {
                    this.board[i][j] = 'F';
                } else {
                    this.board[i][j] = 'O';
                }
            }
        }
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

}
