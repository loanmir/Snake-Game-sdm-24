import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ParseSnake {

    @Test
    @Disabled
    void snakeGrowsAfterEating() {
        Board board = new Board("");
        int[][] tmp = {{5,4},{5,3},{5,2},{4,2}};
        SnakeMovement snakeMovement = new SnakeMovement(board);
        Coordinate coordHead = board.getCoordinateHead();
        ArrayList<Coordinate> coordBody = Coordinate.coordinateArray(tmp);

        SnakeObj snake = new SnakeObj(coordHead, coordBody, snakeMovement);

        snakeMovement.moveHeadRight();
        snake.eatFood();
        ArrayList<Coordinate> newCoordBody= snake.getCoordBody();

        assertEquals(5, newCoordBody.toArray().length);
    }

    @Test
    @Disabled
    void snakeTailRowNotChangingAfterEating() {
        Board board = new Board("");
        int[][] tmp = {{5,4},{5,3},{5,2},{4,2}};

        SnakeMovement snakeMovement = new SnakeMovement(board);
        Coordinate coordHead = board.getCoordinateHead();
        ArrayList<Coordinate> coordBody = Coordinate.coordinateArray(tmp);

        SnakeObj snake = new SnakeObj(coordHead, coordBody, snakeMovement);
        Coordinate coordTail = new Coordinate(tmp[3]);

        snakeMovement.moveHeadRight();
        snake.eatFood();
        Coordinate newCoordTail = snake.getLastPieceOfBodyCoordinate();

        assertEquals(coordTail.getY(), newCoordTail.getY());
        //assertEquals(coordTail.getX(), newCoordTail.getX());
    }

    @Test
    void snakeTailColNotChangingAfterEating() {
        Board board = new Board("");
        int[][] tmp = {{5,4},{5,3},{5,2},{4,2}};

        SnakeMovement snakeMovement = new SnakeMovement(board);
        Coordinate coordHead = board.getCoordinateHead();
        ArrayList<Coordinate> coordBody = Coordinate.coordinateArray(tmp);

        SnakeObj snake = new SnakeObj(coordHead, coordBody, snakeMovement);
        Coordinate coordTail = new Coordinate(tmp[3]);

        snakeMovement.moveHeadRight();
        snake.eatFood();
        Coordinate newCoordTail = snake.getLastPieceOfBodyCoordinate();

        //assertEquals(coordTail.getY(), newCoordTail.getY());
        assertEquals(coordTail.getX(), newCoordTail.getX());
    }
}
