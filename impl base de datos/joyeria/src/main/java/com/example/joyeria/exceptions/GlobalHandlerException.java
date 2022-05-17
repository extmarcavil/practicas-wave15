package com.example.joyeria.exceptions;

import com.example.joyeria.dto.ErrorDTO;
import org.hibernate.exception.ConstraintViolationException;
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
public class GlobalHandlerException {

    @ExceptionHandler(JoyaNotFoundException.class)
    ResponseEntity<ErrorDTO> handlerExceptionJoyaNotFound(JoyaNotFoundException e){
        ErrorDTO errorDTO = new ErrorDTO("Joya no encontrada", e.getMessage(), null);
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<ErrorDTO> notReadableException (HttpMessageNotReadableException exception) {
        ErrorDTO errorDTO = new ErrorDTO("Error al leer payload", exception.getMessage(), null);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorDTO> validationsException (MethodArgumentNotValidException exception) {
        HashMap<String, List<String>> errors = getHashMapErrors(exception.getFieldErrors());

        ErrorDTO errorDTO = new ErrorDTO("Petición inválida","Algunos campos son inválidos", errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<ErrorDTO> validationsException (ConstraintViolationException exception) {
        ErrorDTO errorDTO = new ErrorDTO("Petición inválida",exception.getMessage(), null);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }


    private HashMap<String, List<String>> getHashMapErrors (List<FieldError> errors ) {
        HashMap<String, List<String>> errorsList = new HashMap<>();

        errors.forEach(e -> {
            String field = e.getField();
            String msg = e.getDefaultMessage();

            // Get list of errors of a field.
            List<String> errorFields = new ArrayList<>();
            // If the field alredy exist, add the error to the existing list.
            if (errorsList.containsKey(e.getField())) {
                errorFields = errorsList.get(field);
            }
            errorFields.add(msg);
            // Update list of fields.
            errorsList.put(field, errorFields);
        });

        return errorsList;
    }
}
