import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParseSnakeMovement {

    @Test
    void headMovedUp() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        snakeMovement.setCurrentDirection(Direction.RIGHT);
        //Snake snake = new Snake();
        Cell tmp0 = board.getCell(5,5);
        Cell tmp1 = board.getCell(4,5);
        snakeMovement.moveSnake(Direction.UP);
        Cell tmp2 = board.getCell(4,5);
        Cell tmp3 = board.getCell(5,5);
        System.out.println("Arriving cell before:"+tmp2);
        System.out.println("Starting cell before:"+tmp0);
        System.out.println("Arriving cell after:"+tmp1);
        System.out.println("Starting cell after:"+tmp3);
        assertEquals(Cell.HEAD, board.getCell(4,5));
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
