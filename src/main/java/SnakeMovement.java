public class SnakeMovement {

    private final Board board;

    public SnakeMovement(Board board) {
        this.board = board;
    }

    public boolean isGameOver() {
        int[] rowColHead = board.getRowColHead();
        int headRow = rowColHead[0];
        int headCol = rowColHead[1];

        // Caso 1: La testa esce dal bordo
        if (headRow < 0 || headRow >= Board.getBoardSize() || headCol < 0 || headCol >= Board.getBoardSize()) {
            return true;
        }

        // Caso 2: La testa tocca il corpo
        if (board.getCell(headRow, headCol) == 'S') {
            return true;
        }

        return false;
    }

    // move the head up one and put an S where the H was
    public void moveHeadUp() {
        int[] rowColHead = board.getRowColHead();
        board.setCell(rowColHead[0], rowColHead[1], 'S');
        rowColHead[0]++;
        board.setCell(rowColHead[0], rowColHead[1], 'H');
    }

    // move the head down one and put an S where the H was
    public void moveHeadDown() {
        int[] rowColHead = board.getRowColHead();
        board.setCell(rowColHead[0], rowColHead[1], 'S');
        rowColHead[0]--;
        board.setCell(rowColHead[0], rowColHead[1], 'H');
    }

    // move the head left one and put an S where the H was
    public void moveHeadLeft() {
        int[] rowColHead = board.getRowColHead();
        board.setCell(rowColHead[0], rowColHead[1], 'S');
        rowColHead[1]--;
        board.setCell(rowColHead[0], rowColHead[1], 'H');
    }

    // move the head right one and put an S where the H was
    public void moveHeadRight() {
        int[] rowColHead = board.getRowColHead();
        board.setCell(rowColHead[0], rowColHead[1], 'S');
        rowColHead[1]++;
        board.setCell(rowColHead[0], rowColHead[1], 'H');
    }
}
