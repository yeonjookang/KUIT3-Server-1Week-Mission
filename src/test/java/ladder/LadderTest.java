package ladder;

import ladder.domain.Ladder;
import ladder.exception.ValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리_생성_확인() throws ValidationException {
        //given
        int numberOfRows = 3;
        int numberOfPerson = 5;

        //when
        Ladder ladder  = new Ladder(numberOfRows, numberOfPerson);

        //then
        assertNotNull(ladder);
    }

    @Test
    void 사다리_시작위치_예외_처리() throws ValidationException {
        //given
        int numberOfPerson = 3;
        int numberOfRows = 1;
        Ladder ladder = new Ladder(numberOfRows, numberOfPerson);

        //when
        int position = 3;

        //then
        assertThrows(ValidationException.class, () -> ladder.run(3));
    }

    @Test
    void 사다리_결과_확인() throws ValidationException {
        //given
        int numberOfPerson = 4;
        int numberOfRows = 4;
        Ladder ladder = new Ladder(numberOfRows, numberOfPerson);
        ladder.drawLine(1,0);
        ladder.drawLine(1,2);
        ladder.drawLine(2,1);


        //when
        int position = 0;
        int resultPosition = ladder.run(position);
        //then
        assertEquals(2, resultPosition);

        //when
        position = 1;
        resultPosition = ladder.run(position);
        //then
        assertEquals(0, resultPosition);

        //when
        position = 2;
        resultPosition = ladder.run(position);
        //then
        assertEquals(3, resultPosition);

        //when
        position = 3;
        resultPosition = ladder.run(position);
        //then
        assertEquals(1, resultPosition);



    }
}