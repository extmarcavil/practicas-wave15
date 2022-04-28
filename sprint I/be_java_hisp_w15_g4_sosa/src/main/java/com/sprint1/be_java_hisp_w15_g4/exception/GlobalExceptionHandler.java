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
    public ResponseEntity<ErrorDTO> handlerIDNotFoundException(IDNotFoundException e){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getMessage(),HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(AlreadyFollowingException.class)
    public ResponseEntity<ErrorDTO> handlerAlreadyFollowingException(AlreadyFollowingException e){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getMessage(),HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(NotFollowException.class)
    public ResponseEntity<ErrorDTO> handlerNotFoundException(NotFollowException e){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getMessage(),HttpStatus.BAD_REQUEST));
    }
    @ExceptionHandler(NotFoundFollowingException.class)
    public ResponseEntity<ErrorDTO> handlerNotFoundFollowingException(NotFoundFollowingException e){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getMessage(),HttpStatus.BAD_REQUEST));
    }
}
