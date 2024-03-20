package ladder.domain;

import static ladder.domain.Direction.*;

public class Node {
    private int status;

    public void setStatusRight(){
        this.status = RIGHT.getDirection();
    }

    public void setStatusLeft(){
        this.status = LEFT.getDirection();
    }

    public boolean isLeft() {
        return this.status == LEFT.getDirection();
    }

    public boolean isRight() {
        return this.status == RIGHT.getDirection();
    }
}
