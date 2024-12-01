import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParseSnakeMovement {

    @Test
    void headMovedUp() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        snakeMovement.moveHeadUp();
        Coordinate endingCoordHead = board.getCoordinateHead();
        assertEquals(Cell.HEAD, board.getCell(endingCoordHead));
    }

    @Test
    void headMovedDown() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        snakeMovement.moveHeadDown();
        Coordinate endingCoordHead = board.getCoordinateHead();
        assertEquals(Cell.HEAD, board.getCell(endingCoordHead));
    }

    @Test
    void headMovedLeft() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        snakeMovement.moveHeadLeft();
        Coordinate endingCoordHead = board.getCoordinateHead();
        assertEquals(Cell.HEAD, board.getCell(endingCoordHead));
    }

    @Test
    void headMovedRight() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        snakeMovement.moveHeadRight();
        Coordinate endingCoordHead = board.getCoordinateHead();
        assertEquals(Cell.HEAD, board.getCell(endingCoordHead));
    }
}
