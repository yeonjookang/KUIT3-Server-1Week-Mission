package ladder.domain.wrapper;

import ladder.exception.ErrorMessage;
import ladder.exception.ValidationException;

public class Position {
    private int position;

    public Position(int position) throws ValidationException {
        validatePosition(position);
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public static Position of(int position) throws ValidationException {
        return new Position(position);
    }

    private void validatePosition(int position) throws ValidationException {
        if(position < 0) {
            throw new ValidationException(ErrorMessage.POSITION_IS_NOT_VALID);
        }
    }

    public boolean isBigger(int number){
        return this.position>number;
    }

    public boolean isSmaller(int number){
        return this.position<number;
    }

    public void minusOne() {
        this.position -= 1;
    }

    public void plusOne() {
        this.position += 1;
    }
}
