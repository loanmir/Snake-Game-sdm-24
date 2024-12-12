import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverConditions {

    @Test

    void deathByBorderCollision(){
        //head of the snake up and left
        Board board = new Board("");
        board.setCell(1, 5, Cell.HEAD);
        SnakeMovement snakeMovement = new SnakeMovement(board);

        // moving the head up
        snakeMovement.moveSnake(Direction.UP);

        // verify if the game is finished
        assertTrue(snakeMovement.isGameOver());
    }

    @Test

    void deathBySelfCollision(){
        Board board = new Board();
        SnakeMovement snakeMovement = new SnakeMovement(board);
        snakeMovement.getSnake().setCoordSnake(new ArrayList<>(Arrays.asList(
                new Coordinate(5,5),
                new Coordinate(5, 4),
                new Coordinate(6, 4),
                new Coordinate(6, 5)
        )));

        snakeMovement.moveSnake(Direction.LEFT);
        assertTrue(snakeMovement.isGameOver());
        }



}
