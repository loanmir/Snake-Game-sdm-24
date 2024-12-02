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
    public void moveHead(SnakeObj snake, Direction newDirection) {
        if (currentDirection.isOpposite(newDirection)) {
            return; // ignore, cannot move in this direction
        }

        ArrayList<Coordinate> coordOldBody = snake.getCoordBody();
        Coordinate coordOldHead = board.getCoordinateHead();
        Coordinate coordFood = board.getCoordinateFood();
        System.out.println("coordFood X,Y: " + coordFood.getX()+","+coordFood.getY());
        Coordinate coordNewHead = coordOldHead.plus(newDirection.vector);
        System.out.println("coordNewHead X,Y: " + coordNewHead.getX()+","+coordNewHead.getY());


        if (coordOldBody == null) {  // Movement when snake has no body
            System.out.println("coordNewHead " + coordNewHead);
            if(coordNewHead.equals(coordFood)) {  // Move and eat
                ArrayList<Coordinate> coordNewBody = new ArrayList<>();
                coordNewBody.add(coordOldHead);
                snake.setCoordBody(coordNewBody);
                board.setCell(coordOldHead, Cell.BODY);
                board.setCell(coordNewHead, Cell.HEAD);
            } else {  // just move
                board.setCell(coordOldHead, Cell.BLANK);
                board.setCell(coordNewHead, Cell.HEAD);
            }
        }
        else { // Movement when snake has a body
            ArrayList<Coordinate> coordNewBody = snake.getCoordBody();
            int i = coordNewBody.size();
            if (coordNewHead.equals(coordFood)) {  // Move and eat
                coordNewBody.add(0, coordOldHead);
                board.setCell(coordOldHead, Cell.BODY);
                board.setCell(coordNewHead, Cell.HEAD);
                snake.setCoordBody(coordNewBody);
            } else {  // just move
                board.setCell(coordNewBody.get(i - 1), Cell.BLANK);
                coordNewBody.remove(coordNewBody.size() - 1);
                board.setCell(coordOldHead, Cell.BODY);
                coordNewBody.add(0, coordOldHead);
                board.setCell(coordNewHead, Cell.HEAD);
                snake.setCoordBody(coordNewBody);
            }
        }
        currentDirection = newDirection;
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

