import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParseSnakeMovement {

    @Test
    void headMovedUp() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        SnakeObj snake = new SnakeObj();
        snakeMovement.moveHeadUp(snake);
        Coordinate endingCoordHead = board.getCoordinateHead();
        assertEquals(Cell.HEAD, board.getCell(endingCoordHead));
    }

    @Test
    void headMovedDown() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        SnakeObj snake = new SnakeObj();
        snakeMovement.moveHeadDown(snake);
        Coordinate endingCoordHead = board.getCoordinateHead();
        assertEquals(Cell.HEAD, board.getCell(endingCoordHead));
    }

    @Test
    void headMovedLeft() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        SnakeObj snake = new SnakeObj();
        snakeMovement.moveHeadLeft(snake);
        Coordinate endingCoordHead = board.getCoordinateHead();
        assertEquals(Cell.HEAD, board.getCell(endingCoordHead));
    }

    @Test
    void headMovedRight() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        SnakeObj snake = new SnakeObj();
        snakeMovement.moveHeadRight(snake);
        Coordinate endingCoordHead = board.getCoordinateHead();
        assertEquals(Cell.HEAD, board.getCell(endingCoordHead));
    }
}
