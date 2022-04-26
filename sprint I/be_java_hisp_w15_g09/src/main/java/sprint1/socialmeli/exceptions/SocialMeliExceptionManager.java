package sprint1.socialmeli.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class SocialMeliExceptionManager {


    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<?> userNotFound(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    //@ExceptionHandler
    @ExceptionHandler(InvalidPostException.class)
    public ResponseEntity<?> invalidPostException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
