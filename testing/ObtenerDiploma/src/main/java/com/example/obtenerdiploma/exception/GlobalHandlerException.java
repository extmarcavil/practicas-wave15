package com.example.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice(annotations = RestController.class)
public class GlobalHandlerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException e){
        Map<String, List<String>> fields_errors=new HashMap<>();
        e.getFieldErrors()
                .forEach(fieldError ->{
                    String name=fieldError.getField();
                    fields_errors.putIfAbsent(name,new ArrayList<>());
                    fields_errors.get(name).add(fieldError.getDefaultMessage());
                });

        return new ResponseEntity<>(Map.of( "detail",fields_errors,
                                            "status", HttpStatus.BAD_REQUEST)
                , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,Object> handleValidationExceptions(HttpMessageNotReadableException e){
        return Map.of(  "message", e.getLocalizedMessage(),
                        "status",HttpStatus.BAD_REQUEST);
    }

}
