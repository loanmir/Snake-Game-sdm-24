import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParseBoard {

    @Test
    void boardSizeIsNine() {
        assertEquals(9, Board.getBoardSize());
    }

    @Test
    @Disabled
    void firstCellHasSnakeHead() {
        Board board = new Board();
        assertEquals('H', board.getCell(0, 0));
    }

    @Test
    @Disabled
    void secondCellHasFood() {
        Board board = new Board();
        assertEquals('F', board.getCell(0, 1));
    }

    @Test
    void boardHasOneHead() {
        Board board = new Board();
        int headCounter = 0;
        for (int i = 0; i < Board.getBoardSize(); i++) {
            for (int j = 0; j < Board.getBoardSize(); j++) {
                if (board.getCell(i, j) == 'H') {
                    headCounter++;
                }
            }
        }
        assertEquals(1, headCounter);
    }

    @Test
    void boardHasOneFood() {
        Board board = new Board();
        int foodCounter = 0;
        for (int i = 0; i < Board.getBoardSize(); i++) {
            for (int j = 0; j < Board.getBoardSize(); j++) {
                if (board.getCell(i, j) == 'F') {
                    foodCounter++;
                }
            }
        }
        assertEquals(1, foodCounter);
    }

    @Test
    void foodAdditionInCenterCell() {
        Board board = new Board();
        board.setCell(4, 4, 'F');
        assertEquals('F', board.getCell(4, 4));
    }
}
