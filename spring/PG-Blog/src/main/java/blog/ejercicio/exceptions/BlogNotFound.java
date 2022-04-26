package blog.ejercicio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND , reason = "El recurso no existe")
public class BlogNotFound extends RuntimeException{

    public BlogNotFound(String message) {
        super(message);
    }
}
