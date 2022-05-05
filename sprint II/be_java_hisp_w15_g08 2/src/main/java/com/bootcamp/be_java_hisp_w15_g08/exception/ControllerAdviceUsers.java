package com.bootcamp.be_java_hisp_w15_g08.exception;

import com.bootcamp.be_java_hisp_w15_g08.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ControllerAdvice
public class ControllerAdviceUsers {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException (UserNotFoundException e){
        ErrorDTO errorDTO =new ErrorDTO("User not found",e.getMessage()) ;
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> illegalArgumentException(IllegalArgumentException e){
        ErrorDTO errorDTO = new ErrorDTO("Ilegal arguemnt",e.getMessage());
        return new ResponseEntity<>(errorDTO,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FollowException.class)
    public ResponseEntity<ErrorDTO> FollowException(FollowException e){
        ErrorDTO errorDTO= new ErrorDTO("Follow Error",e.getMessage());
        return new ResponseEntity<>(errorDTO,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorDTO> validationsException ( MethodArgumentNotValidException exception ) {
        HashMap<String, List<String>> errors = getHashMapErrors(exception.getFieldErrors());

        ErrorDTO errorDTO = new ErrorDTO("Some Input are Invalids", errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    private HashMap<String, List<String>> getHashMapErrors (List<FieldError> errors ) {
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
