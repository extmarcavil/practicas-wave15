package com.meli.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GlobalHandlerException {

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ErrorDTO> handlerException ( RuntimeException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("ERROR", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<ErrorDTO> notReadableException ( HttpMessageNotReadableException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("HttpMessageNotReadableException", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
    // Opcion 1
    /* @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorDTO> validationsException ( MethodArgumentNotValidException exception ) {
        HashMap<String, List<String>> errors = getHashMapErrors(exception.getFieldErrors());

        ErrorDTO errorDTO = new ErrorDTO("Some Input are Invalids", errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
    private HashMap<String, List<String>> getHashMapErrors ( List<FieldError> errors ) {
        HashMap<String, List<String>> errorsList = new HashMap<>();

        errors.forEach(e -> {
            String field = e.getField();
            String msg   = e.getDefaultMessage();

            List<String> errorFields = new ArrayList<>();

            if (errorsList.containsKey(e.getField())) {
                errorFields = errorsList.get(field);
            }
            errorFields.add(msg);
            errorsList.put(field, errorFields);
        });

        return errorsList;
    }
    */
   //Opcion 2
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
