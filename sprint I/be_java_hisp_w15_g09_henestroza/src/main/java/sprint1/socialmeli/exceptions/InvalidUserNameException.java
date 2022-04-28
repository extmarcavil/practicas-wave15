package sprint1.socialmeli.exceptions;

public class InvalidUserNameException extends RuntimeException {
    public InvalidUserNameException() {
    }

    public InvalidUserNameException(String message) {
        super(message);
    }
}
