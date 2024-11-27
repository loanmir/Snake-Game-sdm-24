import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameOverConditions {

    @Test
    @Disabled
    void deathByBorderCollision(){
        //head of the snake up and left
        Board board = new Board("");
        board.setCell(0, 0, 'H');
        SnakeMovement snakeMovement = new SnakeMovement(board);

        // moving the head up
        snakeMovement.moveHeadUp();

        // verify if the game is finished
        assertTrue(snakeMovement.isGameOver());
    }

    @Test
    @Disabled
    void deathBySelfCollision(){
                   Board board = new Board("");
            board.setCell(4, 4, 'H');  // head
            board.setCell(4, 3, 'S');  // body
            board.setCell(5, 3, 'S');  // body
            board.setCell(5, 4, 'S');  // body

            SnakeMovement snakeMovement = new SnakeMovement(board);


            snakeMovement.moveHeadLeft(); // head on (4, 3)
            assertFalse(snakeMovement.isGameOver()); //ignore -- not valid movement

            snakeMovement.moveHeadDown(); // head on (5, 4) --> body collision
            assertTrue(snakeMovement.isGameOver());
        }



}
