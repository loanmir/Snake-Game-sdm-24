import java.awt.*;

public class Main {
    public static void main(String[] args){
        System.out.println(333);
        System.out.println(666);

        Board board = new Board();
        SnakeMovement game = new SnakeMovement(board);

        new GameWindow(game);
    }
}
