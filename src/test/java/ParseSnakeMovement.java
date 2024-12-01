import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParseSnakeMovement {

    @Test
    void headMovedUp() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        SnakeObj snake = new SnakeObj();
        snakeMovement.moveHead(snake, Direction.UP);
        Coordinate endingCoordHead = board.getCoordinateHead();
        assertEquals(Cell.HEAD, board.getCell(endingCoordHead));
    }

    @Test
    void headMovedDown() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        SnakeObj snake = new SnakeObj();
        snakeMovement.moveHead(snake, Direction.DOWN);
        Coordinate endingCoordHead = board.getCoordinateHead();
        assertEquals(Cell.HEAD, board.getCell(endingCoordHead));
    }

    @Test
    void headMovedLeft() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        SnakeObj snake = new SnakeObj();
        snakeMovement.moveHead(snake, Direction.LEFT);
        Coordinate endingCoordHead = board.getCoordinateHead();
        assertEquals(Cell.HEAD, board.getCell(endingCoordHead));
    }

    @Test
    void headMovedRight() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        SnakeObj snake = new SnakeObj();
        snakeMovement.moveHead(snake, Direction.RIGHT);
        Coordinate endingCoordHead = board.getCoordinateHead();
        assertEquals(Cell.HEAD, board.getCell(endingCoordHead));
    }
}
