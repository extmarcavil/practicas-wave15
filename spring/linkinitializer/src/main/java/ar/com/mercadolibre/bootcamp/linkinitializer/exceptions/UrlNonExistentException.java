package ar.com.mercadolibre.bootcamp.linkinitializer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "La url no existe")
public class UrlNonExistentException extends RuntimeException {
}
