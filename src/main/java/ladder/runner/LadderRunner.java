package ladder.runner;

import ladder.domain.Row;
import ladder.domain.wrapper.Position;
import ladder.exception.ValidationException;

public class LadderRunner {
    Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) throws ValidationException {
        for(int i = 0; i < rows.length; i++) {
            rows[i].nextPosition(position);
        }
        return position.getPosition();
    }
}
