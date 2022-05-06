package com.bootcamp.be_java_hisp_w15_g02.exception;

import com.bootcamp.be_java_hisp_w15_g02.dto.response.ErrorDTO;
import com.bootcamp.be_java_hisp_w15_g02.model.Follow;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceClient{

    @ExceptionHandler(NotSellerException.class)
    public ResponseEntity<ErrorDTO> cantFollowHandler() {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("El usuario que intentas seguir no es vendedor.");
        errorDTO.setStatus(HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> UserNotFoundException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("El usuario no existe.");
        errorDTO.setStatus(HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorDTO> PostNotFoundException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("El usuario no tiene posts.");
        errorDTO.setStatus(HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorDTO> orderNotFoundHandler(Exception e) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("El tipo de orden no es válido.");
        errorDTO.setStatus(HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FollowYourselfException.class)
    public ResponseEntity<ErrorDTO> followYourselfHandler(Exception e) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("No puede seguirse así mismo.");
        errorDTO.setStatus(HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
