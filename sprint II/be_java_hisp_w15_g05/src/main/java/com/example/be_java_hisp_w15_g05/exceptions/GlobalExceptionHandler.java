package com.example.be_java_hisp_w15_g05.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import java.util.*;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> UserNotFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(UserNotSellerException.class)
    public ResponseEntity<?> UserNotSellerException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(UserNotFollowingException.class)
    public ResponseEntity<?> UserNotFollowingException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(InvalidDateException.class)
    public ResponseEntity<?> InvalidDateException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(InvalidPriceException.class)
    public ResponseEntity<?> InvalidPriceException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(UserAlreadyFollowedException.class)
    public ResponseEntity<?> UserAlreadyFollowedException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(UserCannotFollowHimself.class)
    public ResponseEntity<?> UserCannotFollowHimself(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<ErrorDTO> notReadableException ( HttpMessageNotReadableException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("HttpMessageNotReadableException", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorDTO> validationsException ( MethodArgumentNotValidException exception ) {
        HashMap<String, List<String>> errors = getHashMapErrors(exception.getFieldErrors());

        ErrorDTO errorDTO = new ErrorDTO("Some Input are Invalids", errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<ErrorDTO> pathVariableException( ConstraintViolationException exception){
        ErrorDTO errorDTO = new ErrorDTO("Some Input are Invalids", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    private HashMap<String, List<String>> getHashMapErrors ( List<FieldError> errors ) {
        HashMap<String, List<String>> errorsList = new HashMap<>();

        errors.forEach(e -> {
            String field = e.getField();
            String msg   = e.getDefaultMessage();

            /*
             * Aca lo que se busca es tener siempre la lista de errores de un campo
             * */
            List<String> errorFields = new ArrayList<>();
            /* nos fijamos si ya existe la lista de errores de un campo
             * si existe usamos esa lista para no perder datos
             * sino se empieza de cero
             * */
            if (errorsList.containsKey(e.getField())) {
                errorFields = errorsList.get(field);
            }

            // evitar que se agregen dos veces el mismo mensaje
            if(!errorFields.contains(msg)){
                errorFields.add(msg);
            }

            /* actualizamos la lista de errores de un campo */
            errorsList.put(field, errorFields);
        });

        return errorsList;
    }

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ErrorDTO> handlerException ( RuntimeException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("ERROR", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

}
