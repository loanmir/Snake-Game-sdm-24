public enum Cell {

    BLANK(0),
    BODY(1),
    HEAD(2),
    FOOD(3),
    WALL(4);

    private final int value;

    Cell(int value){
        this.value = value;
    }
}
