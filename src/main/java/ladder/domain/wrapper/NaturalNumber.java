package ladder.domain.wrapper;

import ladder.exception.ErrorMessage;
import ladder.exception.ValidationException;

public class NaturalNumber {
    private final int number;

    public NaturalNumber(int number) throws ValidationException {
        validateNumber(number);
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }

    public static NaturalNumber of(int number) throws ValidationException {
        validateNumber(number);
        return new NaturalNumber(number);
    }

    private static void validateNumber(int number) throws ValidationException {
        if(number < 1) {
            throw new ValidationException(ErrorMessage.IS_NOT_NATURAL_NUMBER);
        }
    }
}
