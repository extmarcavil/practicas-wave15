package ar.com.alehenestroza.joyerialasperlas.exception;

import ar.com.alehenestroza.joyerialasperlas.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionManager {
    @ExceptionHandler(JoyaNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerException(JoyaNotFoundException exception) {
        ErrorDTO errorDTO = new ErrorDTO("JoyaNotFoundException", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
}
