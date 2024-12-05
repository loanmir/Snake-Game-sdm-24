import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ParseSnake {

    @Test
    void snakeGrowsAfterEating() {
        Board board = new Board("");
        int[][] tmp = {{5,4},{5,3},{5,2},{4,2}};
        SnakeMovement snakeMovement = new SnakeMovement(board);
        snakeMovement.setCurrentDirection(Direction.RIGHT);

        System.out.println(board.getCoordinateHead().getX());
        System.out.println(board.getCoordinateHead().getY());

        ArrayList<Coordinate> coordBody = Coordinate.createCoordinateArray(tmp);

        System.out.println("WOW " + coordBody.size());

        snakeMovement.getSnake().setBody(coordBody);
        //Snake snake = new Snake(coordBody);

        System.out.println(board.getCoordinateHead().getX());
        System.out.println(board.getCoordinateHead().getY());

        snakeMovement.moveHead(Direction.RIGHT);

        System.out.println(board.getCoordinateHead().getX());
        System.out.println(board.getCoordinateHead().getY());

        ArrayList<Coordinate> newCoordBody = snakeMovement.getSnake().getBody();

        System.out.println(newCoordBody.get(0).getX());
        System.out.println(newCoordBody.get(0).getY());

        System.out.println(newCoordBody.get(newCoordBody.size()-1).getX());
        System.out.println(newCoordBody.get(newCoordBody.size()-1).getY());

        System.out.println("WOW " + newCoordBody.size());

        assertEquals(5, newCoordBody.size());
    }

    @Test
    void snakeTailRowNotChangingAfterEating() {
        Board board = new Board("");
        int[][] tmp = {{5,4},{5,3},{5,2},{4,2}};
        SnakeMovement snakeMovement = new SnakeMovement(board);
        snakeMovement.setCurrentDirection(Direction.RIGHT);

        ArrayList<Coordinate> coordBody = Coordinate.createCoordinateArray(tmp);

        snakeMovement.getSnake().setBody(coordBody);
        //Snake snake = new Snake(coordBody);
        Coordinate coordTail = new Coordinate(tmp[3]);

        snakeMovement.moveHead(Direction.RIGHT);
        Coordinate newCoordTail = snakeMovement.getSnake().getCoordinateLastPieceOfBody();

        assertEquals(coordTail.getY(), newCoordTail.getY());
    }

    @Test
    void snakeTailColNotChangingAfterEating() {
        Board board = new Board("");
        int[][] body = {{5,4},{5,3},{5,2},{4,2}};
        SnakeMovement snakeMovement = new SnakeMovement(board);
        snakeMovement.setCurrentDirection(Direction.RIGHT);

        ArrayList<Coordinate> coordBody = Coordinate.createCoordinateArray(body);

        snakeMovement.getSnake().setBody(coordBody);
        //Snake snake = new Snake(coordBody);
        Coordinate coordTail = new Coordinate(body[3]);

        snakeMovement.moveHead(Direction.RIGHT);
        Coordinate newCoordTail = snakeMovement.getSnake().getCoordinateLastPieceOfBody();

        assertEquals(coordTail.getX(), newCoordTail.getX());
    }
}
