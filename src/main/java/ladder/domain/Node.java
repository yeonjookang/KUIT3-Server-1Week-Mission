package ladder.domain;

public class Node {
    private int status;

    public void setStatusRight(){
        this.status = Direction.RIGHT.getDirection();
    }

    public void setStatusLeft(){
        this.status = Direction.LEFT.getDirection();
    }

    public boolean isLeft() {
        return this.status == Direction.LEFT.getDirection();
    }

    public boolean isRight() {
        return this.status == Direction.RIGHT.getDirection();
    }
}
