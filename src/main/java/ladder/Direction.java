package ladder;

public enum Direction {
    RIGHT(1),
    LEFT(-1);

    private int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int getDirection(){
        return this.direction;
    }
}
