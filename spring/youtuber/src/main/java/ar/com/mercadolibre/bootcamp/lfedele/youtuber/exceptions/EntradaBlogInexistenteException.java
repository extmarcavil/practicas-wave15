package ar.com.mercadolibre.bootcamp.lfedele.youtuber.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntradaBlogInexistenteException extends RuntimeException {
    public EntradaBlogInexistenteException(Long id) {
        super("No existe una entrada con id " + id);
    }
}
