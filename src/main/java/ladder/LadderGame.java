package ladder;

import ladder.creator.LadderCreator;
import ladder.domain.wrapper.Position;
import ladder.exception.ValidationException;
import ladder.runner.LadderRunner;

public class LadderGame {
    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int run(Position position) throws ValidationException {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        return ladderRunner.run(position);
    }
}
