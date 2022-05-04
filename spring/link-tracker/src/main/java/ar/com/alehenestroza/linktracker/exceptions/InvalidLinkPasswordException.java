package ar.com.alehenestroza.linktracker.exceptions;

public class InvalidLinkPasswordException extends RuntimeException {
    public InvalidLinkPasswordException() {
    }

    public InvalidLinkPasswordException(String message) {
        super(message);
    }
}
