package ladder.domain;

import ladder.domain.wrapper.NaturalNumber;
import ladder.domain.wrapper.Position;
import ladder.exception.ValidationException;

public class Ladder {

    private Row[] rows;

    public Ladder(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) throws ValidationException {
        rows = new Row[numberOfRows.getNumber()];

        for(int i = 0; i < numberOfRows.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(int row, Position col) throws ValidationException {
        rows[row].drawLine(col);
    }

    public int run(Position position) throws ValidationException {

        for(int i = 0; i < rows.length; i++) {
            rows[i].nextPosition(position);
        }
        return position.getPosition();
    }
}
