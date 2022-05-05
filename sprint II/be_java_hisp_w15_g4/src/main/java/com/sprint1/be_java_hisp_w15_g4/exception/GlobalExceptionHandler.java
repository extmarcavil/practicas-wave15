package com.sprint1.be_java_hisp_w15_g4.exception;

import com.sprint1.be_java_hisp_w15_g4.dto.response.ErrorDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.ValidationErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(IDNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerNotFoundException(IDNotFoundException e){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO(e.getMessage(),HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(AlreadyFollowing.class)
    public ResponseEntity<ErrorDTO> handlerNotFoundException(AlreadyFollowing e){
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorDTO(e.getMessage(),HttpStatus.CONFLICT));
    }

    @ExceptionHandler(NotFollowException.class)
    public ResponseEntity<ErrorDTO> handlerNotFoundException(NotFollowException e){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getMessage(),HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(EqualsIDException.class)
    public ResponseEntity<ErrorDTO> handlerEqualsIDException(EqualsIDException e){
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorDTO(e.getMessage(),HttpStatus.CONFLICT));
    }

    @ExceptionHandler(BadOrderArgumentExcepcion.class)
    public ResponseEntity<ErrorDTO> handlerBadOrderArgumentExcepcion(BadOrderArgumentExcepcion e){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getMessage(),HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException e){
        Map<String, List<String>> errors = new HashMap<>();

        e.getFieldErrors().forEach(fieldError -> {
                    String name = fieldError.getField();
                    errors.putIfAbsent(name, new ArrayList<>());
                    errors.get(name).add(fieldError.getDefaultMessage());
                    });

        return ResponseEntity.badRequest().body(new ValidationErrorDTO(HttpStatus.BAD_REQUEST, errors));
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleValidationExceptions(HttpMessageNotReadableException e){
        return ResponseEntity.badRequest().body(new ErrorDTO(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST));
    }
}
