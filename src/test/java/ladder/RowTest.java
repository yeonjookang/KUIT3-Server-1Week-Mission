package ladder;

import ladder.domain.wrapper.NaturalNumber;
import ladder.domain.Row;
import ladder.domain.wrapper.Position;
import ladder.exception.ValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    void 참여자_한_명_사다리_이동() throws ValidationException {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(1);
        Row row = new Row(numberOfPerson);

        //when
        Position position = Position.of(0);

        //then
        assertEquals(0,position.getPosition());
    }

    @Test
    void 참여자_두_명_사다리_열간_이동() throws ValidationException {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(2);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));

        //when
        Position position = Position.of(0);;
        row.nextPosition(position);
        //then
        assertEquals(1,position.getPosition());


        //when
        position = Position.of(1);;
        row.nextPosition(position);
        //then
        assertEquals(0, position.getPosition());
    }

    @Test
    void 참여자_세_명_사다리_열간_이동() throws ValidationException {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));

        //when
        Position position = Position.of(0);;
        row.nextPosition(position);
        //then
        assertEquals(1,position);

        //when
        position = Position.of(1);;
        row.nextPosition(position);
        //then
        assertEquals(0, position);

        //when
        position = Position.of(2);;
        row.nextPosition(position);
        //then
        assertEquals(2, position);
    }

    @Test
    void 사다리_사람수_예외_처리() throws ValidationException {
        assertThrows(ValidationException.class, () -> NaturalNumber.of(0));
    }

    @Test
    void 사다리_위치_최대값_초과_예외_처리() throws ValidationException {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);

        //when
        Position position = Position.of(3);;

        //then
        assertThrows(ValidationException.class, () -> row.nextPosition(position));
    }

    @Test
    void 사다리_위치_최소값_미만_예외_처리() throws ValidationException {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);

        //then
        assertThrows(ValidationException.class, () -> Position.of(-1));
    }

    @Test
    void 사다리_라인_그리기_위치_초과_예외() throws ValidationException {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);

        //when
        Position lineStartPosition = Position.of(2);

        //then
        assertThrows(ValidationException.class, () -> row.drawLine(lineStartPosition));
    }

    @Test
    void 사다리_라인_그리기_위치_미만_예외() throws ValidationException {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);

        //then
        assertThrows(ValidationException.class, () -> Position.of(-1));
    }

    @Test
    void 라인_그리기_좌측_라인_중복_예외() throws ValidationException {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));

        //when
        Position lineStartPosition = Position.of(1);

        //then
        assertThrows(ValidationException.class, () -> row.drawLine(lineStartPosition));

    }

    @Test
    void 라인_그리기_우측_라인_중복_예외() throws ValidationException {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(1));

        //when
        Position lineStartPosition = Position.of(0);

        //then
        assertThrows(ValidationException.class, () -> row.drawLine(lineStartPosition));

    }

}