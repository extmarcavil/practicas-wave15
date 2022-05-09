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
    public ResponseEntity<ErrorDTO> handlerException(RuntimeException exception) {
        ErrorDTO errorDTO = new ErrorDTO("RuntimeException", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ErrorDTO> userNotFound(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO("UserNotFound",e.getMessage()));
    }

    @ExceptionHandler(InvalidPostException.class)
    public ResponseEntity<ErrorDTO> invalidPostException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO("InvalidPostException",e.getMessage()));
    }

    @ExceptionHandler(InvalidFollower.class)
    public ResponseEntity<ErrorDTO> invalidFollower(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO("InvalidFollower",e.getMessage()));
    }

    @ExceptionHandler(InvalidParamsException.class)
    public ResponseEntity<ErrorDTO> invalidParams(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO("InvalidParamsException",e.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> notReadableException(HttpMessageNotReadableException exception) {
        ErrorDTO errorDTO = new ErrorDTO("HttpMessageNotReadableException", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> validationsException(MethodArgumentNotValidException exception) {
        HashMap<String, List<String>> errors = getHashMapErrors(exception.getFieldErrors());
        ErrorDTO errorDTO = new ErrorDTO("MethodArgumentNotValidException", errors);
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