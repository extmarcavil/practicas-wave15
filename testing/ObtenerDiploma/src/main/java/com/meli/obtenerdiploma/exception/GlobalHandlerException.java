package com.meli.obtenerdiploma.exception;

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

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ErrorDTO> handlerException (RuntimeException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("ERROR", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<ErrorDTO> notReadableException ( HttpMessageNotReadableException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("HttpMessageNotReadableException", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    /* Opcion 1
     * Si el codigo parece muy raro pueden usar la opcion 2 que es un poco mas simple
     * solo tienen que comentar esta funcion
     * */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorDTO> validationsException ( MethodArgumentNotValidException exception ) {
        HashMap<String, List<String>> errors = getHashMapErrors(exception.getFieldErrors());

        ErrorDTO errorDTO = new ErrorDTO("Some Input are Invalids", errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    // Opcion 2 para ver las validaciones que no se cumplen
/*    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorDTO> validationsException ( MethodArgumentNotValidException exception ) {
        List<String> errors = exception.getFieldErrors()
          .stream()
          .map(fieldError -> fieldError.getDefaultMessage())
          .collect(Collectors.toList());

        ErrorDTO errorDTO = new ErrorDTO("Some Input are Invalids", errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }*/

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
