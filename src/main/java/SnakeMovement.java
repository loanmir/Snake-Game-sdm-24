public class SnakeMovement {

    private final Board board;
    private Direction currentDirection = Direction.NULL;

    public SnakeMovement(Board board) {
        this.board = board;
    }

    public boolean isGameOver() {
        Coordinate coordHead = board.getCoordinateHead();
        int headRow = coordHead.getY();
        int headCol = coordHead.getX();

        // Caso 1: La testa esce dal bordo
        if (headRow <= 0 || headRow >= Board.getBoardSize() - 1 || headCol <= 0 || headCol >= Board.getBoardSize() - 1) {
            return true;
        }

        // Caso 2: La testa tocca il corpo
        if (board.getCell(headRow, headCol) == Cell.BODY) {
            return true;
        }

        return false;
    }

    // move the head up one and put an S where the H was
    public void moveHeadUp() {
        if (currentDirection == Direction.DOWN) {
            return; // ignore, cannot move in this direction
        }
        Coordinate coordHead = board.getCoordinateHead();
        board.setCell(coordHead, Cell.BODY);
        coordHead.plus(Direction.UP.vector);
        board.setCell(coordHead, Cell.HEAD);
        currentDirection = Direction.UP;
    }

    // move the head down one and put an S where the H was
    public void moveHeadDown() {
        if (currentDirection == Direction.UP) {
            return; //  ignore, cannot move in this direction
        }
        Coordinate coordHead = board.getCoordinateHead();
        board.setCell(coordHead, Cell.BODY);
        coordHead.plus(Direction.DOWN.vector);
        board.setCell(coordHead, Cell.HEAD);
        currentDirection = Direction.DOWN;
    }

    // move the head left one and put an S where the H was
    public void moveHeadLeft() {
        if (currentDirection == Direction.RIGHT) {
            return; // ignore, cannot move in this direction
        }
        Coordinate coordHead = board.getCoordinateHead();
        board.setCell(coordHead, Cell.BODY);
        coordHead.plus(Direction.LEFT.vector);
        board.setCell(coordHead, Cell.HEAD);
        currentDirection = Direction.LEFT;
    }

    // move the head right one and put an S where the H was
    public void moveHeadRight() {
        if (currentDirection == Direction.LEFT) {
            return; // ignore, cannot move in this direction
        }
        Coordinate coordHead = board.getCoordinateHead();
        board.setCell(coordHead, Cell.BODY);
        coordHead.plus(Direction.RIGHT.vector);
        board.setCell(coordHead, Cell.HEAD);
        currentDirection = Direction.UP;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction direction) {
        this.currentDirection = direction;
    }

    public Cell[][] getBoardState() {
        return this.board.getBoard();
    }


}

