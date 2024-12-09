import java.awt.*;

public class Main {

    static final Coordinate BOARD_DIM = new Coordinate(11,11);

    public static void main(String[] args){
        System.out.println(333);
        System.out.println(666);

        Board board = new Board();
        //Cell[][] game = new Cell[][];
        SnakeMovement game = new SnakeMovement(board);

        new GameWindow(game);
    }
}
