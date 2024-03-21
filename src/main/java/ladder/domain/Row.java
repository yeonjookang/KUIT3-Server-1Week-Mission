package ladder.domain;

import ladder.domain.wrapper.NaturalNumber;
import ladder.domain.wrapper.Node;
import ladder.domain.wrapper.Position;
import ladder.exception.ErrorMessage;
import ladder.exception.ValidationException;

public class Row {
    private Node[] nodes;

    public Row(NaturalNumber numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()];
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            nodes[i] = new Node();
        }
    }

    public void drawLine(Position lineStartPosition) throws ValidationException {
        validateDrawLinePosition(lineStartPosition);
        setLine(lineStartPosition);
    }

    public void nextPosition(Position position) throws ValidationException {
        validatePosition(position);

        if (isLeft(position)) {
            position.minusOne();
            System.out.println(position.getPosition());
        }
        if (isRight(position)) {
            position.plusOne();
        }
    }

    private boolean isLeft(Position position) {
        return nodes[position.getPosition()].isLeft();
    }

    private boolean isRight(Position position) {
        return nodes[position.getPosition()].isRight();
    }

    private void validateDrawLinePosition(Position lineStartPosition) throws ValidationException {
        if(lineStartPosition.isBigger(nodes.length - 2)
                || isAlreadyHaveLine(lineStartPosition)) {
            throw new ValidationException(ErrorMessage.DRAW_LINE_POSITION_IS_NOT_VALID);
        }
    }

    private void validatePosition(Position position) throws ValidationException {
        if(position.isBigger(nodes.length-1)) {
            throw new ValidationException(ErrorMessage.POSITION_IS_NOT_VALID);
        }
    }

    private boolean isAlreadyHaveLine(Position lineStartPosition) {
        if(nodes[lineStartPosition.getPosition()].isLeft() || nodes[lineStartPosition.getPosition() + 1].isRight())
            return true;
        return false;
    }

    public void setLine(Position position){
        nodes[position.getPosition()].setStatusRight();
        nodes[position.getPosition() + 1].setStatusLeft();
    }
}
