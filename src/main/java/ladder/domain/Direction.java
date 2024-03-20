package ladder.domain;

public enum Direction {
    RIGHT(1),
    LEFT(-1),
    NONE(0);

    private int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int getDirection(){
        return this.direction;
    }
}
