import java.util.ArrayList;
import java.util.Objects;

public class Snake {
    private ArrayList<Coordinate> body;
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

    public Snake(ArrayList<Coordinate> coordBody) {
        this.body = coordBody;
    }


    public Snake() {
        this.body = null;
    }

    /*public ArrayList<Coordinate> getBody() {
        return body;
    }*/

    public void setBody(ArrayList<Coordinate> body) {
        this.body = body;
    }

    public Coordinate getCoordinateLastPieceOfBody() {
        int len = body.toArray().length;
        return body.get(len-1);
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

    public ArrayList<Coordinate> getBody() {
        return this.body;
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
        return Objects.equals(getBody(), snake.getBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBody());
    }
}
