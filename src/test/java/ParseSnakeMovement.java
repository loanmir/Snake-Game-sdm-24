import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParseSnakeMovement {

    @Test
    void headMovedUp() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        int[] startingRowCol = board.getRowColHead();
        snakeMovement.moveHeadUp();
        int[] endingRowCol = board.getRowColHead();
        assertEquals('H', board.getCell(endingRowCol[0], endingRowCol[1]));
    }

    @Test
    void headMovedDown() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        int[] startingRowCol = board.getRowColHead();
        snakeMovement.moveHeadDown();
        int[] endingRowCol = board.getRowColHead();
        assertEquals('H', board.getCell(endingRowCol[0], endingRowCol[1]));
    }

    @Test
    void headMovedLeft() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        int[] startingRowCol = board.getRowColHead();
        snakeMovement.moveHeadLeft();
        int[] endingRowCol = board.getRowColHead();
        assertEquals('H', board.getCell(endingRowCol[0], endingRowCol[1]));
    }

    @Test
    void headMovedRight() {
        Board board = new Board("");
        SnakeMovement snakeMovement = new SnakeMovement(board);
        int[] startingRowCol = board.getRowColHead();
        snakeMovement.moveHeadRight();
        int[] endingRowCol = board.getRowColHead();
        assertEquals('H', board.getCell(endingRowCol[0], endingRowCol[1]));
    }
}
