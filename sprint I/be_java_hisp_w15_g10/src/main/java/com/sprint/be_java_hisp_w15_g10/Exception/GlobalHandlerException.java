package com.sprint.be_java_hisp_w15_g10.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerNotFoundUserException (UserNotFoundException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("NOT FOUND USER", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundPostException.class)
    public ResponseEntity<ErrorDTO> handlerNotFoundUserPostException (UserNotFoundPostException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("NOT FOUND USER", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CategoryNotFoundPostException.class)
    public ResponseEntity<ErrorDTO> handlerNotFoundCategoryPostException (CategoryNotFoundPostException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("NOT FOUND CATEGORY", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<ErrorDTO> handlerDateTimeParseException (DateTimeParseException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("FAILED TO DESERIALIZE", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFollowException.class)
    public ResponseEntity<ErrorDTO> handlerNotFollowUserException (NotFollowException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("NOT FOUND RELATION", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
