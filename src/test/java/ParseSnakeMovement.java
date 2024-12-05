import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParseSnakeMovement {

    @Test
    void headMovedUp() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        snakeMovement.setCurrentDirection(Direction.RIGHT);
        Snake snake = new Snake();
        snakeMovement.moveHead(Direction.UP);
        Coordinate endingCoordHead = board.getCoordinateHead();
        assertEquals(Cell.HEAD, board.getCell(endingCoordHead));
    }

    @Test
    void headMovedDown() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        snakeMovement.setCurrentDirection(Direction.RIGHT);
        Snake snake = new Snake();
        snakeMovement.moveHead(Direction.DOWN);
        Coordinate endingCoordHead = board.getCoordinateHead();
        assertEquals(Cell.HEAD, board.getCell(endingCoordHead));
    }

    @Test
    void headMovedLeft() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        snakeMovement.setCurrentDirection(Direction.DOWN);
        Snake snake = new Snake();
        snakeMovement.moveHead(Direction.LEFT);
        Coordinate endingCoordHead = board.getCoordinateHead();
        assertEquals(Cell.HEAD, board.getCell(endingCoordHead));
    }

    @Test
    void headMovedRight() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        snakeMovement.setCurrentDirection(Direction.RIGHT);
        Snake snake = new Snake();
        snakeMovement.moveHead(Direction.RIGHT);
        Coordinate endingCoordHead = board.getCoordinateHead();
        assertEquals(Cell.HEAD, board.getCell(endingCoordHead));
    }

    @Disabled
    @Test
    void foodIsEaten(){
        //I have to do it :)

    }
}
