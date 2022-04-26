package blog.ejercicio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED , reason = "El recurso ya existe")
public class BlogAlreadyExist extends RuntimeException {

public BlogAlreadyExist(String message) {
       super(message);
    }
}
