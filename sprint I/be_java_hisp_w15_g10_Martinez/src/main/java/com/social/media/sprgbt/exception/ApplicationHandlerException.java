package com.social.media.sprgbt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationHandlerException {

    /**
     * ExistingUserException.
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ExistingException.class)
    public ResponseEntity<?> existingUserException(Exception e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    /**
     * NotFoundException.
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(Exception e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }


    /**
     * Exception.
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> defaultException(Exception e) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.getMessage());
    }


}
