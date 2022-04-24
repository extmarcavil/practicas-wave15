package ar.com.mercadolibre.bootcamp.lfedele.youtuber.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EntradaBlogConIdDuplicadoException extends RuntimeException {
    public EntradaBlogConIdDuplicadoException(Long id) {
        super("Ya existe una entrada con id " + id);
    }
}
