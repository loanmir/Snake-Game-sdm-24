import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParseMovement {
    @Test
    void headGoUp() {
        Board board = new Board();
        Movement movement = new Movement(board);
        int[] startingRowCol = board.getRowColHead();
        movement.moveHeadUp();
        int[] endingRowCol = board.getRowColHead();
        assertNotEquals('H', board.getCell(startingRowCol[0], startingRowCol[1]));
        assertEquals('H', board.getCell(endingRowCol[0], endingRowCol[1]));
    }
}
