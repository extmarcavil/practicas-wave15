package blog.ejercicio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionManager {

    @ExceptionHandler(BlogAlreadyExist.class)
    public ResponseEntity<?> BlogAlreadyExist( Exception e){
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(e.getMessage());
    }

    //@ExceptionHandler(BlogNotFound.class)
    //public ResponseEntity<?> BlogNotFound( Exception e){
    //   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    //}

}

