package com.bootcamp.be_java_hisp_w15_g08.exception;

import com.bootcamp.be_java_hisp_w15_g08.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceUsers {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException (UserNotFoundException e){
        ErrorDTO errorDTO =new ErrorDTO("User not found",e.getMessage()) ;
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
}
