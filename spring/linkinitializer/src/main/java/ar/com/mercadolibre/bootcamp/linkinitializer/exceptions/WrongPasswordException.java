package ar.com.mercadolibre.bootcamp.linkinitializer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Incorrect password")
public class WrongPasswordException extends  RuntimeException{
}
