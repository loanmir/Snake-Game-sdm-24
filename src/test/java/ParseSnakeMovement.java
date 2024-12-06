import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParseSnakeMovement {

    @Test
    void headMovedUpNoEatingSnakeHeadGetsUpdated() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        snakeMovement.setCurrentDirection(Direction.RIGHT);
        snakeMovement.moveSnake(Direction.UP);
        assertEquals(Cell.HEAD, board.getCell(4,5));
    }

    @Test
    void headMovedUpNoEatingSnakeBodyGetsUpdated() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        snakeMovement.setCurrentDirection(Direction.RIGHT);
        snakeMovement.moveSnake(Direction.UP);
        assertEquals(Cell.BLANK, board.getCell(5,5));
    }

    @Test
    void headMovedUpWhileEatingSnakeBodyGetsUpdated() {
        Board board = new Board("");
        board.setCell(5,6, Cell.BLANK);
        board.setCell(4,5, Cell.FOOD);
        SnakeMovement snakeMovement = new SnakeMovement(board);
        snakeMovement.setCurrentDirection(Direction.RIGHT);
        snakeMovement.moveSnake(Direction.UP);
        assertEquals(Cell.BODY, board.getCell(5,5));
    }

    @Test
    @Disabled
    void headMovedDown() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        snakeMovement.setCurrentDirection(Direction.RIGHT);
        //Snake snake = new Snake();
        snakeMovement.moveSnake(Direction.DOWN);
        assertEquals(Cell.HEAD, board.getCell(6,5));
    }

    @Test
    @Disabled
    void headMovedLeft() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        snakeMovement.setCurrentDirection(Direction.DOWN);
        //Snake snake = new Snake();
        snakeMovement.moveSnake(Direction.LEFT);

        assertEquals(Cell.HEAD, board.getCell(5,4));
    }

    @Test
    @Disabled
    void headMovedRight() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        snakeMovement.setCurrentDirection(Direction.RIGHT);
        //Snake snake = new Snake();
        snakeMovement.moveSnake(Direction.RIGHT);
        assertEquals(Cell.HEAD, board.getCell(5,6));
    }

    @Disabled
    @Test
    void foodIsEaten(){
        //I have to do it :)

    }
}
