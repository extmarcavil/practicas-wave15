package sprint1.socialmeli.exceptions;

public class InvalidPromoPostException extends RuntimeException {
    public InvalidPromoPostException() {
    }

    public InvalidPromoPostException(String message) {
        super(message);
    }
}
