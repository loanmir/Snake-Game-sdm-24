public class Movement {

    private final Board board;

    public Movement(Board board) {
        this.board = board;
    }

    public void moveHeadUp() {
        int[] rowColHead = board.getRowColHead();
        board.setCell(rowColHead[0], rowColHead[1], 'S');
        rowColHead[0]++;
        board.setCell(rowColHead[0], rowColHead[1], 'H');
    }

    public void moveHeadDown() {
        int[] rowColHead = board.getRowColHead();
        board.setCell(rowColHead[0], rowColHead[1], 'S');
        rowColHead[0]--;
        board.setCell(rowColHead[0], rowColHead[1], 'H');
    }

    public void moveHeadLeft() {
        int[] rowColHead = board.getRowColHead();
        board.setCell(rowColHead[0], rowColHead[1], 'S');
        rowColHead[1]--;
        board.setCell(rowColHead[0], rowColHead[1], 'H');
    }

    public void moveHeadRight() {
        int[] rowColHead = board.getRowColHead();
        board.setCell(rowColHead[0], rowColHead[1], 'S');
        rowColHead[1]++;
        board.setCell(rowColHead[0], rowColHead[1], 'H');
    }
}
