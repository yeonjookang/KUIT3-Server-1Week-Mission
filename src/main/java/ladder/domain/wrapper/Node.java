package ladder.domain.wrapper;

import ladder.domain.enumcalss.Direction;

import static ladder.domain.enumcalss.Direction.*;

public class Node {
    private Direction status;

    public void setStatusRight(){
        this.status = RIGHT;
    }

    public void setStatusLeft(){
        this.status = LEFT;
    }

    public boolean isLeft() {
        return this.status == LEFT;
    }

    public boolean isRight() {
        return this.status == RIGHT;
    }
}
