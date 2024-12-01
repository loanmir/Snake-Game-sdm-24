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

        ArrayList<Coordinate> coordBody = Coordinate.createCoordinateArray(tmp);

        SnakeObj snake = new SnakeObj(coordBody);

        snakeMovement.moveHead(snake, Direction.RIGHT);
        snake.eatFood();
        ArrayList<Coordinate> newCoordBody= snake.getCoordBody();

        assertEquals(5, newCoordBody.toArray().length);
    }

    @Test
    void snakeTailRowNotChangingAfterEating() {
        Board board = new Board("");
        int[][] tmp = {{5,4},{5,3},{5,2},{4,2}};

        SnakeMovement snakeMovement = new SnakeMovement(board);

        ArrayList<Coordinate> coordBody = Coordinate.createCoordinateArray(tmp);

        SnakeObj snake = new SnakeObj(coordBody);
        Coordinate coordTail = new Coordinate(tmp[3]);

        snakeMovement.moveHead(snake, Direction.RIGHT);
        snake.eatFood();
        Coordinate newCoordTail = snake.getCoordinateLastPieceOfBody();

        assertEquals(coordTail.getY(), newCoordTail.getY());
    }

    @Test
    void snakeTailColNotChangingAfterEating() {
        Board board = new Board("");
        int[][] body = {{5,4},{5,3},{5,2},{4,2}};

        SnakeMovement snakeMovement = new SnakeMovement(board);

        ArrayList<Coordinate> coordBody = Coordinate.createCoordinateArray(body);

        SnakeObj snake = new SnakeObj(coordBody);
        Coordinate coordTail = new Coordinate(body[3]);

        snakeMovement.moveHead(snake, Direction.RIGHT);
        snake.eatFood();
        Coordinate newCoordTail = snake.getCoordinateLastPieceOfBody();

        assertEquals(coordTail.getX(), newCoordTail.getX());
    }
}
