package com.be.java.hisp.w156.be.java.hisp.w156.exception;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ControllerAdvice
public class ControllerAdviceExceptions {

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ErrorDTO> handlerException (RuntimeException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("ERROR", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<ErrorDTO> notReadableException ( HttpMessageNotReadableException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("HttpMessageNotReadableException", exception.getRootCause().getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {UserNotFoundException.class})
    protected ResponseEntity<ErrorDTO> UserNotFoundException(RuntimeException ex){
        ErrorDTO errorDTO = new ErrorDTO("UserNotFoundException", ex.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {UserNotFollowedException.class})
    protected ResponseEntity<ErrorDTO> UserNotFollowedException(RuntimeException ex){
        ErrorDTO errorDTO = new ErrorDTO("UserNotFollowedException", ex.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {UserCantFollowHimselfException.class})
    protected ResponseEntity<ErrorDTO> UserCantFollowHimselfException(RuntimeException ex){
        ErrorDTO errorDTO = new ErrorDTO("UserCantFollowHimselfException", ex.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {UserAlreadyFollowsTheUserException.class})
    protected ResponseEntity<ErrorDTO> UserAlreadyFollowsTheUserException(RuntimeException ex){
        ErrorDTO errorDTO = new ErrorDTO("UserAlreadyFollowsTheUserException", ex.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorDTO> validationsException ( MethodArgumentNotValidException exception ) {
        HashMap<String, List<String>> errors = getHashMapErrors(exception.getFieldErrors());

        ErrorDTO errorDTO = new ErrorDTO("Algunos valores de entrada son incorrectos.", errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    /*
     * la lista de errores puede contener errores que pertenecen al mismo campo y por eso
     * se crear una estructura un poco rara
     * */
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
            errorFields.add(msg);
            /* actualizamos la lista de errores de un campo */
            errorsList.put(field, errorFields);
        });

        return errorsList;
    }
}
