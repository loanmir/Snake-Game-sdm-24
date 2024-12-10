import java.util.ArrayList;

public class SnakeMovement {

    private final Board board;
    private Snake snake;
    private int score;
    //private final Food food;
    private Direction currentDirection = Direction.NULL;

    // CoordBody[0] refers to the parte of the body closest to the head

    public SnakeMovement(Board board) {
        // This constructor instantiate a Snake object with only the head
        // If we need a snake with more than just the head we should modify it with snake.setCoordSnake(ArrayList<Coordinates>)
        this.board = board;
        this.snake = new Snake(board.getCoordinateHead());
        this.score = 0;
    }

    public void moveSnake(Direction newDirection) {
        ArrayList<Coordinate> coordSnake = snake.getCoordSnake();  // get current snake coord
        Coordinate coordSnakeTail = coordSnake.get(coordSnake.size() - 1);  // get current tail coord
        Coordinate coordSnakeHeadBefore = coordSnake.get(0);  // get current head

        if (newDirection.isOpposite(this.currentDirection)) {  // can't turn 180°
            ;
        } else {
            // Calculate new head position
            Coordinate coordSnakeHeadAfter = coordSnakeHeadBefore.plus(newDirection.vector);

            // Determine if snake grows (eats food)
            boolean grows = coordSnakeHeadAfter.equals(board.getCoordinateFood());

            // Update the board and snake coordinates
            board.setCell(coordSnakeHeadBefore, Cell.BODY); // Current head becomes body
            coordSnake.add(0, coordSnakeHeadAfter); // Add new head

            if (!grows) {
                // Remove tail if not growing
                coordSnake.remove(coordSnake.size() - 1);
                board.setCell(coordSnakeTail, Cell.BLANK); // Clear old tail
            } else {
                // Consume food and regenerate new food
                eatFood(coordSnakeHeadAfter);
            }


            // Update the new head on the board
            board.setCell(coordSnakeHeadAfter, Cell.HEAD);

            // Update snake coordinates
            snake.setCoordSnake(coordSnake);
        }
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


    public void eatFood(Coordinate headPosition) {
            // Check if the head position matches the current food position
            if (headPosition.equals(board.getCoordinateFood())) {
                // Regenerate food only if the head consumes the food
                board.regenerateFood();
            }
            // If the head is not at the food position, do nothing
    }


    public Direction getCurrentDirection() { //not used
        return currentDirection;
    }

    public void setCurrentDirection(Direction direction) {
        this.currentDirection = direction;
    }

    public Cell[][] getBoardState() {
        return this.board.getBoard();
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public int getScore() {
        return this.score;
    }


}

