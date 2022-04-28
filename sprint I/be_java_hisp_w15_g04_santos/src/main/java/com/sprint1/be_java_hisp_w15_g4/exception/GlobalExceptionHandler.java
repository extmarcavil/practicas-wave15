package com.sprint1.be_java_hisp_w15_g4.exception;

import com.sprint1.be_java_hisp_w15_g4.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(IDNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerNotFoundIdException(IDNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO(e.getMessage(),HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(AlreadyFollowingException.class)
    public ResponseEntity<ErrorDTO> handlerAlreadyFollowingException(AlreadyFollowingException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorDTO(e.getMessage(),HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(NotFollowException.class)
    public ResponseEntity<ErrorDTO> handlerNotFollowException(NotFollowException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorDTO(e.getMessage(),HttpStatus.CONFLICT));
    }

    @ExceptionHandler(SameUserIdException.class)
    public ResponseEntity<ErrorDTO> handlerSameUserIdException(SameUserIdException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorDTO(e.getMessage(), HttpStatus.CONFLICT));
    }

}
