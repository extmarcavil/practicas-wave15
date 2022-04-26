package ar.com.mercadolibre.bootcamp.linkinitializer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Ya existe la url")
public class UrlExistentException extends RuntimeException {
}
