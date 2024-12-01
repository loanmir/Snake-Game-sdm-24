import java.util.ArrayList;

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

    // move the head up one and put an S where the H was, return the coordinates of the old body.
    public ArrayList<Coordinate> moveHeadUp(SnakeObj snake) {
        if (currentDirection == Direction.DOWN) {
            return null; // ignore, cannot move in this direction
        }
        Coordinate coordHead = board.getCoordinateHead();
        ArrayList<Coordinate> oldCoordBody = snake.getCoordBody();
        board.setCell(coordHead, Cell.BODY);
        coordHead.plus(Direction.UP.vector);
        board.setCell(coordHead, Cell.HEAD);
        currentDirection = Direction.UP;
        return oldCoordBody;
    }

    // move the head down one and put an S where the H was
    public ArrayList<Coordinate> moveHeadDown(SnakeObj snake) {
        if (currentDirection == Direction.UP) {
            return null; //  ignore, cannot move in this direction
        }
        Coordinate coordHead = board.getCoordinateHead();
        ArrayList<Coordinate> oldCoordBody = snake.getCoordBody();
        board.setCell(coordHead, Cell.BODY);
        coordHead.plus(Direction.DOWN.vector);
        board.setCell(coordHead, Cell.HEAD);
        currentDirection = Direction.DOWN;
        return oldCoordBody;
    }

    // move the head left one and put an S where the H was
    public ArrayList<Coordinate> moveHeadLeft(SnakeObj snake) {
        if (currentDirection == Direction.RIGHT) {
            return null; // ignore, cannot move in this direction
        }
        Coordinate coordHead = board.getCoordinateHead();
        ArrayList<Coordinate> oldCoordBody = snake.getCoordBody();
        board.setCell(coordHead, Cell.BODY);
        coordHead.plus(Direction.LEFT.vector);
        board.setCell(coordHead, Cell.HEAD);
        currentDirection = Direction.LEFT;
        return oldCoordBody;
    }

    // move the head right one and put an S where the H was
    public ArrayList<Coordinate> moveHeadRight(SnakeObj snake) {
        if (currentDirection == Direction.LEFT) {
            return null; // ignore, cannot move in this direction
        }
        Coordinate coordHead = board.getCoordinateHead();
        ArrayList<Coordinate> oldCoordBody = snake.getCoordBody();
        board.setCell(coordHead, Cell.BODY);
        coordHead.plus(Direction.RIGHT.vector);
        board.setCell(coordHead, Cell.HEAD);
        currentDirection = Direction.UP;
        return oldCoordBody;
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

