package ladder.domain;

import ladder.exception.ValidationException;

public class Ladder {

    private Row[] rows;

    public Ladder(int numberOfRows, int numberOfPerson) throws ValidationException {
        rows = new Row[numberOfPerson];

        for(int i = 0; i < numberOfRows; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(int row, int col) throws ValidationException {
        rows[row].drawLine(col);
    }

    public int run(int position) throws ValidationException {

        for(int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }

        return position;
    }
}
