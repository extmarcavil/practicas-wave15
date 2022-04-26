package ar.com.mercadolibre.bootcamp.linkinitializer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomMalformedUrlException extends RuntimeException {
    public CustomMalformedUrlException(String url) {
        super("Url invalida: " + url);
    }
}
