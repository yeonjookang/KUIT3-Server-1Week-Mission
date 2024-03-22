package ladder;

import ladder.creator.LadderCreator;
import ladder.domain.wrapper.NaturalNumber;
import ladder.domain.wrapper.Position;
import ladder.exception.ValidationException;
import ladder.runner.LadderRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    LadderCreator ladderCreator;
    LadderRunner ladderRunner;

    @Test
    void 사다리_생성_확인() throws ValidationException {
        //given
        NaturalNumber numberOfRows = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        ladderCreator = new LadderCreator(numberOfRows,numberOfPerson);

        //then
        assertNotNull(ladderCreator);
    }

    @Test
    void 사다리_시작위치_예외_처리() throws ValidationException {
        //given
        NaturalNumber numberOfRows = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(1);
        ladderCreator = new LadderCreator(numberOfRows,numberOfPerson);
        ladderRunner = new LadderRunner(ladderCreator.getRows());

        //when
        Position position = Position.of(3);

        //then
        assertThrows(ValidationException.class, () -> ladderRunner.run(position));
    }

    @Test
    void 사다리_결과_확인() throws ValidationException {
        //given
        NaturalNumber numberOfRows = NaturalNumber.of(4);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        ladderCreator = new LadderCreator(numberOfRows,numberOfPerson);
        ladderRunner = new LadderRunner(ladderCreator.getRows());
        ladderCreator.drawLine(1, Position.of(0));
        ladderCreator.drawLine(1,Position.of(2));
        ladderCreator.drawLine(2,Position.of(1));

        //when
        Position position = Position.of(0);;
        int resultPosition = ladderRunner.run(position);
        //then
        assertEquals(2, resultPosition);

        //when
        position = Position.of(1);;
        resultPosition = ladderRunner.run(position);
        //then
        assertEquals(0, resultPosition);

        //when
        position = Position.of(2);;
        resultPosition = ladderRunner.run(position);
        //then
        assertEquals(3, resultPosition);

        //when
        position = Position.of(3);;
        resultPosition = ladderRunner.run(position);
        //then
        assertEquals(1, resultPosition);
    }
}