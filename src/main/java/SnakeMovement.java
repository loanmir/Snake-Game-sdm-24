import java.util.ArrayList;

public class SnakeMovement {

    private final Board board;
    private Direction currentDirection = Direction.NULL;

    // CoordBody[0] refers to the parte of the body closest to the head

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
    public void moveHead(Snake snake, Direction newDirection) {
        if (currentDirection.isOpposite(newDirection)) {
            return; // ignore, cannot move in this direction
        }

        // Saving coordOldBody, coordFood, coordOldHead for later use
        // Saving coordNewHead to check if the food is colliding with the head
        ArrayList<Coordinate> coordOldBody = snake.getCoordBody();
        Coordinate coordOldHead = board.getCoordinateHead();
        Coordinate coordFood = board.getCoordinateFood();
        // System.out.println("coordFood X,Y: " + coordFood.getX()+","+coordFood.getY());
        Coordinate coordNewHead = coordOldHead.plus(newDirection.vector);
        // System.out.println("coordNewHead X,Y: " + coordNewHead.getX()+","+coordNewHead.getY());


        if (coordOldBody == null) {  // Movement when snake has no body
            // System.out.println("coordNewHead " + coordNewHead);
            if(coordNewHead.equals(coordFood)) {  // Move head and instantiate the body coords
                ArrayList<Coordinate> coordNewBody = new ArrayList<>();  // Instantiate the coord of the body
                coordNewBody.add(coordOldHead);  // adding the first coord of the ArrayList that is the coord of the head before moving
                snake.setCoordBody(coordNewBody);  // Updating coord body after moving
                board.setCell(coordOldHead, Cell.BODY);
                board.setCell(coordNewHead, Cell.HEAD);
            } else {  // Move just the head without instantiating the body coords
                board.setCell(coordOldHead, Cell.BLANK);
                board.setCell(coordNewHead, Cell.HEAD);
            }
        }
        else { // Movement when snake has a body
            ArrayList<Coordinate> coordNewBody = snake.getCoordBody();  // Instantiating the ArrayList<Coordinate> that we modify
            int i = coordNewBody.size();
            if (coordNewHead.equals(coordFood)) {  // Move and eat
                coordNewBody.add(0, coordOldHead);  // Adding the coord of the head before the movement to the ArrayList<Coordinate> because the body follows the head
                board.setCell(coordOldHead, Cell.BODY);
                board.setCell(coordNewHead, Cell.HEAD);
                snake.setCoordBody(coordNewBody);  // Updating the coord of the body in the snake
            } else {  // Movement without eating
                board.setCell(coordOldBody.get(i - 1), Cell.BLANK);  // setting the tail of the snake to blank because we advance one step
                coordNewBody.remove(coordNewBody.size() - 1);  // removing form the coord of the body the coord of the tail we just changed
                board.setCell(coordOldHead, Cell.BODY);
                coordNewBody.add(0, coordOldHead);  // Adding the coord of the head before the movement to the ArrayList<Coordinate> because the body follows the head
                board.setCell(coordNewHead, Cell.HEAD);
                snake.setCoordBody(coordNewBody);  // Updating the coord of the body in the snake
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

