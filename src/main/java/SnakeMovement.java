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
        this.snake = new Snake(board.getInitialCoordinateHead());
        this.score = 0;
    }

    public void moveSnake(Direction newDirection) {

        ArrayList<Coordinate> coordSnake = snake.getCoordSnake();  // get current snake coord
        Coordinate coordSnakeTail = coordSnake.get(coordSnake.size() - 1);  // get current tail coord
        Coordinate coordSnakeHeadBefore = coordSnake.get(0);  // get current head

        //System.out.println("Current dir: " + this.currentDirection);
        //System.out.println("New dir: " + newDirection);

        if (newDirection.isOpposite(this.currentDirection) && coordSnake.size() > 1) {  // can't turn 180°
            newDirection = this.currentDirection;
        }

            // Update the current direction
            this.currentDirection = newDirection;

            // Calculate new head position
            Coordinate coordSnakeHeadAfter = coordSnakeHeadBefore.plus(newDirection.vector);

            // Determine if snake grows (eats food)
            boolean grows = coordSnakeHeadAfter.equals(board.getCoordinateFood());

            // Update the board and snake coordinates
            board.setCell(coordSnakeHeadBefore, Cell.SNAKE); // Current head becomes body
            coordSnake.add(0, coordSnakeHeadAfter); // Add new head

            if (!grows) {
                // Remove tail if not growing
                coordSnake.remove(coordSnake.size() - 1);
                board.setCell(coordSnakeTail, Cell.BLANK); // Clear old tail
            } else {
                // Consume food and regenerate new food
                eatFood(coordSnakeHeadAfter);
                score++;
            }

            // Update the new head on the board (if grows, it replaces the food)
            board.setCell(coordSnakeHeadAfter, Cell.SNAKE);

            // Update snake coordinates
            snake.setCoordSnake(coordSnake);

        }

    public boolean isGameOver() {
        ArrayList<Coordinate> coordSnake = snake.getCoordSnake();
        Coordinate head = coordSnake.get(0);  // The head is at index 0 in the list
        int headRow = head.getY();
        int headCol = head.getX();

        // Case 1: Check if the head is colliding with the wall
        if (headRow <= 0 || headRow >= board.getBoardSize() - 1 || headCol <= 0 || headCol >= board.getBoardSize() - 1) {
            return true;  // The game is over if the head goes out of bounds (hits the wall)
        }

        // second case : self collision
        ArrayList<Coordinate> coordBody = new ArrayList<>(coordSnake.subList(1, coordSnake.size())); // body without head

        System.out.println("head" + head + " body" + coordBody);

        if (coordBody.contains(head)) {
            System.out.println("Game Over: Head collided with body");
            return true;
        }

        return false;
    }


    public void eatFood(Coordinate foodPosition) {
        Coordinate head = snake.getCoordSnake().get(0);

        //if head is in the food position
        if (head.equals(foodPosition)) {
            //increment the snake
            //ArrayList<Coordinate> body = snake.getCoordSnake();
            //Coordinate tail = body.get(body.size() - 1); //last cell of the body


            //body.add(new Coordinate(tail.getX(), tail.getY()));
            //snake.setCoordSnake(body);

            //new food
            board.regenerateFood();
        }
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

