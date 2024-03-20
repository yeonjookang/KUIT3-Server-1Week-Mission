package ladder;

public enum Direction {
    RIGHT(1),
    LEFT(-1),
    NONE(0);

    private int direction;

    Direction(int direction) {
        this.direction = direction;
    }

}
