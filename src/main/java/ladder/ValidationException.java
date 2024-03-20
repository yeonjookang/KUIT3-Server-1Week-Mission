package ladder;

public class ValidationException extends Exception{
    public ValidationException(ErrorMessage message) {
        super(message.name());
    }
}
