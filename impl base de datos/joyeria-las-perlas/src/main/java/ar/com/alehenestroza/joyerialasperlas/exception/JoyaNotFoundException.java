package ar.com.alehenestroza.joyerialasperlas.exception;

public class JoyaNotFoundException extends RuntimeException {
    public JoyaNotFoundException() {
    }

    public JoyaNotFoundException(String message) {
        super(message);
    }
}
