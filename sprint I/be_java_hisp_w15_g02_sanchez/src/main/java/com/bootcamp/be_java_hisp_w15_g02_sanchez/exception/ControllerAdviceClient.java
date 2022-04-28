package com.bootcamp.be_java_hisp_w15_g02_sanchez.exception;

import com.bootcamp.be_java_hisp_w15_g02_sanchez.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This is the exception handler class
 */
@ControllerAdvice
public class ControllerAdviceClient{

    /**
     * This method handles the exception thrown when a user can't be followed because he is not a seller
     * @return The response entity containing the exception
     */
    @ExceptionHandler(NotSellerException.class)
    public ResponseEntity<ErrorDTO> cantFollowHandler() {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("El usuario que intentas seguir no es vendedor.");
        errorDTO.setStatus(HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    /**
     * This method handles the exception thrown when a user doesn't exist
     * @param e The exception thrown
     * @return The response entity containing the exception
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> UserNotFoundException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("El usuario no existe.");
        errorDTO.setStatus(HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorDTO> PostNotFoundException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("El usuario no tiene posts.");
        errorDTO.setStatus(HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.NOT_FOUND);
    }

    /**
     * This method handles the exception thrown when a given order is not valid
     * @param e The exception thrown
     * @return The response entity containing the exception
     */
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorDTO> orderNotFoundHandler(Exception e) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("Tipo de orden no válido.");
        errorDTO.setStatus(HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    /**
     * This method handles the exception thrown when a user try to follow yourself.
     * @param e The exception thrown
     * @return The response entity containing the exception
     */
    @ExceptionHandler(FollowYourselfException.class)
    public ResponseEntity<ErrorDTO> followYourselfHandler(Exception e) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(e.getMessage());
        errorDTO.setStatus(HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
