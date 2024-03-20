package ladder.domain;

import ladder.exception.ErrorMessage;
import ladder.exception.ValidationException;

public class Row {
    private Node[] nodes;

    public Row(int numberOfPerson) throws ValidationException {
        validateNumberOfPerson(numberOfPerson);

        nodes = new Node[numberOfPerson];
        for (int i = 0; i < numberOfPerson; i++) {
            nodes[i] = new Node();
        }
    }

    public void drawLine(int lineStartPosition) throws ValidationException {
        validateDrawLinePosition(lineStartPosition);
        nodes[lineStartPosition].setStatusRight();
        nodes[lineStartPosition + 1].setStatusLeft();
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
        return nodes[position].isLeft();
    }

    private boolean isRight(int position) {
        return nodes[position].isRight();
    }

    private void validateNumberOfPerson(int numberOfPerson) throws ValidationException {
        if(numberOfPerson < 1) {
            throw new ValidationException(ErrorMessage.PERSON_NUM_IS_NOT_VALID);
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) throws ValidationException {
        if(lineStartPosition < 0 || lineStartPosition >= nodes.length - 1
                || nodes[lineStartPosition].isLeft() || nodes[lineStartPosition + 1].isRight()) {
            throw new ValidationException(ErrorMessage.DRAW_LINE_POSITION_IS_NOT_VALID);
        }
    }

    private void validatePosition(int position) throws ValidationException {
        if(position >= nodes.length || position < 0 ) {
            throw new ValidationException(ErrorMessage.POSITION_IS_NOT_VALID);
        }
    }

}
