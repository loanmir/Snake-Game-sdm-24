import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParseMovement {

    @Test
    void headMovedUp() {
        Board board = new Board();
        Movement movement = new Movement(board);
        int[] startingRowCol = board.getRowColHead();
        movement.moveHeadUp();
        int[] endingRowCol = board.getRowColHead();
        assertNotEquals('H', board.getCell(startingRowCol[0], startingRowCol[1]));
        assertEquals('H', board.getCell(endingRowCol[0], endingRowCol[1]));
    }

    @Test
    void headMovedDown() {
        Board board = new Board();
        Movement movement = new Movement(board);
        int[] startingRowCol = board.getRowColHead();
        movement.moveHeadDown();
        int[] endingRowCol = board.getRowColHead();
        assertNotEquals('H', board.getCell(startingRowCol[0], startingRowCol[1]));
        assertEquals('H', board.getCell(endingRowCol[0], endingRowCol[1]));
    }

    @Test
    void headMovedLeft() {
        Board board = new Board();
        Movement movement = new Movement(board);
        int[] startingRowCol = board.getRowColHead();
        movement.moveHeadLeft();
        int[] endingRowCol = board.getRowColHead();
        assertNotEquals('H', board.getCell(startingRowCol[0], startingRowCol[1]));
        assertEquals('H', board.getCell(endingRowCol[0], endingRowCol[1]));
    }

    @Test
    void headMovedRight() {
        Board board = new Board();
        Movement movement = new Movement(board);
        int[] startingRowCol = board.getRowColHead();
        movement.moveHeadRight();
        int[] endingRowCol = board.getRowColHead();
        assertNotEquals('H', board.getCell(startingRowCol[0], startingRowCol[1]));
        assertEquals('H', board.getCell(endingRowCol[0], endingRowCol[1]));
    }
}
