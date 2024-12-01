import java.util.ArrayList;
import java.util.Objects;

public class SnakeObj {
    private Coordinate coordHead;
    private ArrayList<Coordinate> coordBody;
    private SnakeMovement snakeMovement;

    // Coordinate[0] coordBody refers to the parte of the body closest to the head

    public SnakeObj(Coordinate coordHead, ArrayList<Coordinate> coordBody, SnakeMovement snakeMovement) {
        this.coordHead = coordHead;
        this.coordBody = coordBody;
        this.snakeMovement = snakeMovement;
    }

    public SnakeObj(Coordinate coordHead, SnakeMovement snakeMovement) {
        this.coordHead = coordHead;
        this.coordBody = null;
        this.snakeMovement = snakeMovement;
    }

    public Coordinate getCoordHead() {
        return coordHead;
    }

    public ArrayList<Coordinate> getCoordBody() {
        return coordBody;
    }

    public Coordinate getLastPieceOfBodyCoordinate() {
        int len = coordBody.toArray().length;
        return coordBody.get(len-1);
    }

    public SnakeMovement getSnakeMovement() {
        return snakeMovement;
    }

    public void setCoordHead(Coordinate coordHead) {
        this.coordHead = coordHead;
    }

    public void setCoordBody(ArrayList<Coordinate> coordBody) {
        this.coordBody = coordBody;
    }

    public void setSnakeMovement(SnakeMovement snakeMovement) {
        this.snakeMovement = snakeMovement;
    }

    public void eatFood() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SnakeObj snakeObj)) return false;
        return Objects.equals(getCoordHead(), snakeObj.getCoordHead()) && Objects.equals(getCoordBody(), snakeObj.getCoordBody()) && Objects.equals(getSnakeMovement(), snakeObj.getSnakeMovement());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoordHead(), getCoordBody(), getSnakeMovement());
    }
}
