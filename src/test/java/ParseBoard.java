import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParseBoard {

    @Test
    void BoardSizeIsNine() {
        assertEquals(9, Board.getBoardSize());
    }

    @Test
    void FirstCellHasSnakeHead() {
        Board board = new Board();
        assertEquals('H', board.getCell(0, 0));
    }

    @Test
    void SecondCellHasFood() {
        Board board = new Board();
        assertEquals('F', board.getCell(0, 1));
    }
}
