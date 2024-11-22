public class Movement {

    private Board board;

    public Movement(Board board) {
        this.board = board;
    }

    public void moveHeadUp() {
        int[] rowColHead = board.getRowColHead();
        board.setCell(rowColHead[0], rowColHead[1], '0');
        rowColHead[0]++;
        board.setCell(rowColHead[0], rowColHead[1], 'H');
    }


}
