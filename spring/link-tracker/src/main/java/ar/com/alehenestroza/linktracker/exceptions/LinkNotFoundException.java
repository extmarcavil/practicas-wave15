package ar.com.alehenestroza.linktracker.exceptions;

public class LinkNotFoundException extends RuntimeException {
    public LinkNotFoundException() {
    }

    public LinkNotFoundException(String message) {
        super(message);
    }
}
