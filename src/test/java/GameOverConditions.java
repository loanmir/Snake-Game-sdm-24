import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameOverConditions {

    @Test
    @Disabled
    void deathByBorderCollision(){
        // Posizioniamo la testa dello Snake nell'angolo in alto a sinistra
        Board board = new Board("");
        board.setCell(0, 0, 'H'); // La testa è in alto a sinistra
        SnakeMovement snakeMovement = new SnakeMovement(board);

        // Muoviamo la testa verso l'alto
        snakeMovement.moveHeadUp();

        // Verifichiamo se il gioco è finito
        assertTrue(snakeMovement.isGameOver());
    }

    @Test
    @Disabled
    void deathBySelfCollision(){
    //devo ancora farlo :)

    }
}