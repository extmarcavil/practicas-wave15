package com.sprint.be_java_hisp_w15_g10.Exception;

import com.sprint.be_java_hisp_w15_g10.DTO.ErrorDTO;
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

    @ExceptionHandler(DuplicatedEntityException.class)
    public ResponseEntity<ErrorDTO> handlerDuplicatedEntityException (DuplicatedEntityException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("DUPLICATE ENTITY", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerUserNotFoundException (UserNotFoundException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("USER NOT FOUND", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerPostNotFoundException (PostNotFoundException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("POST NOT FOUND", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerProductNotFoundException (ProductNotFoundException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("PRODUCT NOT FOUND", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundPostException.class)
    public ResponseEntity<ErrorDTO> handlerNotFoundUserPostException (UserNotFoundPostException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("USER NOT FOUND", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CategoryNotFoundPostException.class)
    public ResponseEntity<ErrorDTO> handlerNotFoundCategoryPostException (CategoryNotFoundPostException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("CATEGORY NOT FOUND", exception.getMessage());
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

    @ExceptionHandler(FollowException.class)
    public ResponseEntity<ErrorDTO> handlerFollowUserException (FollowException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("IS A FOLLOWER", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SelfException.class)
    public ResponseEntity<ErrorDTO> handlerSelfException (SelfException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("FORBIDDEN", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotAPromoException.class)
    public ResponseEntity<ErrorDTO> handlerNotAPromoException (NotAPromoException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("NOT A PROMO", exception.getMessage());
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
