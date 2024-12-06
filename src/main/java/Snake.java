import java.util.ArrayList;
import java.util.Objects;

public class Snake {
    private ArrayList<Coordinate> coordSnake;
    private Coordinate head;
    private Direction direction;
    private int length;

    //CoordBody[0] refers to the parte of the body closest to the head

    /*public Snake(Coordinate initialPosition) {
        this.head = initialPosition;
        this.direction = Direction.NULL;
        this.length = 1;
        this.body = new ArrayList<Coordinate>();
        this.body.add(initialPosition);
    }*/

    public Snake(ArrayList<Coordinate> coordSnake) {
        this.coordSnake = coordSnake;
        this.head = coordSnake.get(0);
        this.direction = Direction.NULL;
        this.length = 1;
    }

    public Snake() {
        this.coordSnake = null;
    }

    /*public ArrayList<Coordinate> getBody() {
        return body;
    }*/

    public void setCoordSnake(ArrayList<Coordinate> coordSnake) {
        this.coordSnake = coordSnake;
    }

    public Coordinate getCoordinateLastPieceOfBody() {
        int len = coordSnake.toArray().length;
        return coordSnake.get(len-1);
    }

    public void grow() {
        length++;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Coordinate getHeadPosition() {
        return this.head;
    }

    public ArrayList<Coordinate> getCoordSnake() {
        return this.coordSnake;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Snake snake)) return false;
        return Objects.equals(getCoordSnake(), snake.getCoordSnake());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoordSnake());
    }
}
