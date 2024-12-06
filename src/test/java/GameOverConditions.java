import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameOverConditions {

    @Test
    @Disabled
    void deathByBorderCollision(){
        //head of the snake up and left
        Board board = new Board("");
        board.setCell(0, 0, Cell.HEAD);
        SnakeMovement snakeMovement = new SnakeMovement(board);
        //Snake snake = new Snake();

        // moving the head up
        snakeMovement.moveSnake(Direction.UP);

        // verify if the game is finished
        assertTrue(snakeMovement.isGameOver());
    }

    @Test
    @Disabled
    void deathBySelfCollision(){
                   Board board = new Board("");
            board.setCell(4, 4, Cell.HEAD);  // head
            board.setCell(4, 3, Cell.BODY);  // body
            board.setCell(5, 3, Cell.BODY);  // body
            board.setCell(5, 4, Cell.BODY);  // body

            SnakeMovement snakeMovement = new SnakeMovement(board);
            //Snake snake = new Snake();


            snakeMovement.moveSnake(Direction.LEFT); // head on (4, 3)
            assertFalse(snakeMovement.isGameOver()); //ignore -- not valid movement

            snakeMovement.moveSnake(Direction.DOWN); // head on (5, 4) --> body collision
            assertTrue(snakeMovement.isGameOver());
        }



}
