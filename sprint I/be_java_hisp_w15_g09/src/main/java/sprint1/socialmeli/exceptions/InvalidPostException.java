package sprint1.socialmeli.exceptions;

public class InvalidPostException extends RuntimeException {
    public InvalidPostException() {
    }

    public InvalidPostException(String message) {
        super(message);
    }
}
