public class SnakeMovement {

    private final Board board;
    private Direction currentDirection = Direction.NULL;

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
        if (currentDirection == Direction.DOWN) {
            return; // ignore, cannot move in this direction
        }
        int[] rowColHead = board.getRowColHead();
        board.setCell(rowColHead[0], rowColHead[1], 'S');
        rowColHead[0]++;
        board.setCell(rowColHead[0], rowColHead[1], 'H');
        currentDirection = Direction.UP;
    }

    // move the head down one and put an S where the H was
    public void moveHeadDown() {
        if (currentDirection == Direction.UP) {
            return; //  ignore, cannot move in this direction
        }
        int[] rowColHead = board.getRowColHead();
        board.setCell(rowColHead[0], rowColHead[1], 'S');
        rowColHead[0]--;
        board.setCell(rowColHead[0], rowColHead[1], 'H');
        currentDirection = Direction.DOWN;
    }

    // move the head left one and put an S where the H was
    public void moveHeadLeft() {
        if (currentDirection == Direction.RIGHT) {
            return; // ignore, cannot move in this direction
        }
        int[] rowColHead = board.getRowColHead();
        board.setCell(rowColHead[0], rowColHead[1], 'S');
        rowColHead[1]--;
        board.setCell(rowColHead[0], rowColHead[1], 'H');
        currentDirection = Direction.LEFT;
    }

    // move the head right one and put an S where the H was
    public void moveHeadRight() {
        if (currentDirection == Direction.LEFT) {
            return; // ignore, cannot move in this direction
        }
        int[] rowColHead = board.getRowColHead();
        board.setCell(rowColHead[0], rowColHead[1], 'S');
        rowColHead[1]++;
        board.setCell(rowColHead[0], rowColHead[1], 'H');
        currentDirection = Direction.RIGHT;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }
    public void setCurrentDirection(Direction direction) {
        this.currentDirection = direction;
    }

        public Character[][] getBoardState(){
            return this.board.getBoard();
        }


}

