package sprint2.socialmeli.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ControllerAdvice(annotations = RestController.class)
public class SocialMeliExceptionManager {


    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ErrorDTO> handlerException(RuntimeException exception) {
        ErrorDTO errorDTO = new ErrorDTO("ERROR", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<?> userNotFound(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(InvalidPostException.class)
    public ResponseEntity<?> invalidPostException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(InvalidFollower.class)
    public ResponseEntity<?> invalidFollower(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(InvalidParamsException.class)
    public ResponseEntity<?> invalidParams(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<ErrorDTO> notReadableException(HttpMessageNotReadableException exception) {
        ErrorDTO errorDTO = new ErrorDTO("HttpMessageNotReadableException", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorDTO> validationsException(MethodArgumentNotValidException exception) {
        HashMap<String, List<String>> errors = getHashMapErrors(exception.getFieldErrors());

        ErrorDTO errorDTO = new ErrorDTO("Some Input are Invalids", errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    private HashMap<String, List<String>> getHashMapErrors(List<FieldError> errors) {
        HashMap<String, List<String>> errorsList = new HashMap<>();

        errors.forEach(e -> {
            String field = e.getField();
            String msg = e.getDefaultMessage();

            List<String> errorFields = new ArrayList<>();

            if (errorsList.containsKey(e.getField())) {
                errorFields = errorsList.get(field);
            }
            errorFields.add(msg);
            errorsList.put(field, errorFields);
        });

        return errorsList;
    }
}