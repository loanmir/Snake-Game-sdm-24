import java.util.ArrayList;
import java.util.Objects;

public class SnakeObj {
    private ArrayList<Coordinate> coordBody;

    // CoordBody[0] refers to the parte of the body closest to the head

    public SnakeObj(ArrayList<Coordinate> coordBody) {
        this.coordBody = coordBody;
    }

    public SnakeObj() {
        this.coordBody = null;
    }

    public ArrayList<Coordinate> getCoordBody() {
        return coordBody;
    }

    public Coordinate getCoordinateLastPieceOfBody() {
        int len = coordBody.toArray().length;
        return coordBody.get(len-1);
    }

    public void setCoordBody(ArrayList<Coordinate> coordBody) {
        this.coordBody = coordBody;
    }

    public void eatFood() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SnakeObj snakeObj)) return false;
        return Objects.equals(getCoordBody(), snakeObj.getCoordBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoordBody());
    }
}
