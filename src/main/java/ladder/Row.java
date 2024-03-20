package ladder;

import ladder.exception.ErrorMessage;
import ladder.exception.ValidationException;

public class Row {
    private Direction[] row;

    public Row(int numberOfPerson) throws ValidationException {
        validateNumberOfPerson(numberOfPerson);
        row = new Direction[numberOfPerson];
    }

    public void drawLine(int lineStartPosition) throws ValidationException {
        validateDrawLinePosition(lineStartPosition);
        row[lineStartPosition] = Direction.RIGHT;
        row[lineStartPosition + 1] = Direction.LEFT;
    }

    public int nextPosition(int position) throws ValidationException {
        validatePosition(position);

        if (isLeft(position)) {
            return position - 1;
        }
        if (isRight(position)) {
            return position + 1;
        }

        return position;
    }

    private boolean isLeft(int position) {
        return row[position] == Direction.LEFT;
    }

    private boolean isRight(int position) {
        return row[position] == Direction.RIGHT;
    }

    private void validateNumberOfPerson(int numberOfPerson) throws ValidationException {
        if(numberOfPerson < 1) {
            throw new ValidationException(ErrorMessage.PERSON_NUM_IS_NOT_VALID);
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) throws ValidationException {
        if(lineStartPosition < 0 || lineStartPosition >= row.length - 1
                || row[lineStartPosition] == Direction.LEFT || row[lineStartPosition + 1] == Direction.RIGHT) {
            throw new ValidationException(ErrorMessage.DRAW_LINE_POSITION_IS_NOT_VALID);
        }
    }

    private void validatePosition(int position) throws ValidationException {
        if(position >= row.length || position < 0 ) {
            throw new ValidationException(ErrorMessage.POSITION_IS_NOT_VALID);
        }
    }

}
