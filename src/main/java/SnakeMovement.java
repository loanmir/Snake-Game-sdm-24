public class SnakeMovement {

    private final Board board;

    public SnakeMovement(Board board) {
        this.board = board;
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
