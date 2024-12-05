import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParseBoard {

    @Test
    void boardSizeIsEleven() {
        assertEquals(11, Board.getBoardSize());
    }

    @Test
    @Disabled
    void firstCellHasSnakeHead() {
        Board board = new Board();
        assertEquals(Cell.HEAD, board.getCell(0, 0));
    }

    @Test
    @Disabled
    void secondCellHasFood() {
        Board board = new Board();
        assertEquals(Cell.FOOD, board.getCell(0, 1));
    }

    @Test
    void boardHasOneHead() {
        Board board = new Board();
        int headCounter = 0;
        for (int i = 0; i < Board.getBoardSize(); i++) {
            for (int j = 0; j < Board.getBoardSize(); j++) {
                if (board.getCell(i, j) == Cell.HEAD) {
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
                if (board.getCell(i, j) == Cell.FOOD) {
                    foodCounter++;
                }
            }
        }
        assertEquals(1, foodCounter);
    }

    @Test
    void foodAdditionInCenterCell() {
        Board board = new Board();
        board.setCell(4, 4, Cell.FOOD);
        assertEquals(Cell.FOOD, board.getCell(4, 4));
    }

    @Test
    void wallsAtEdgesOfBoard() {
        Board board = new Board();
        for (int i = 0; i < Board.getBoardSize(); i++) {
            for (int j = 0; j < Board.getBoardSize(); j++) {
                if (i == 0 || i == 10 || j == 0 || j == 10) {
                    assertEquals(Cell.WALL, board.getCell(i, j));
                } else {
                    assertNotEquals(Cell.WALL, board.getCell(i, j));
                }
            }
        }
    }



    @Disabled
    @Test
    void NewFoodIsSpawnedAfterEating() {
        Board board = new Board();
        Coordinate initialFoodPosition = board.getCoordinateFood(); //initial food position
        SnakeMovement snakeMovement = new SnakeMovement(board);

        snakeMovement.eatFood(initialFoodPosition);
        board.regenerateFood(); // new piece of food

        Coordinate newFoodPosition = board.getCoordinateFood(); //new position of the food

        assertNotEquals(initialFoodPosition, newFoodPosition); //new food in a different position
        assertEquals(Cell.FOOD, board.getCell(newFoodPosition.getY(), newFoodPosition.getX())); //the new position contains the food
    }


}
