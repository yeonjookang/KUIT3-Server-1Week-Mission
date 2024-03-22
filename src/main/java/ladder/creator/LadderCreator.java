package ladder.creator;

import ladder.domain.Row;
import ladder.domain.wrapper.NaturalNumber;
import ladder.domain.wrapper.Position;
import ladder.exception.ValidationException;

public class LadderCreator {

    private Row[] rows;

    public LadderCreator(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) throws ValidationException {
        rows = new Row[numberOfRows.getNumber()];

        for(int i = 0; i < numberOfRows.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(int row, Position col) throws ValidationException {
        rows[row].drawLine(col);
    }

    public Row[] getRows() {
        return rows;
    }

}
