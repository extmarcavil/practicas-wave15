package sprint2.socialmeli.exceptions;

public class InvalidParamsException extends RuntimeException {
    public InvalidParamsException() {
    }

    public InvalidParamsException(String message) {
        super(message);
    }
}
