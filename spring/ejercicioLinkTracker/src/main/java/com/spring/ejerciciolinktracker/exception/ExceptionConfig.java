package com.spring.ejerciciolinktracker.exception;

import com.spring.ejerciciolinktracker.dto.NotFoundDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundDTO> linkNotFound(NotFoundException e) {
        NotFoundDTO notFound = new NotFoundDTO();
        notFound.setName("LinkId invalido");
        notFound.setDescription(e.getMessage());
        return new ResponseEntity<>(notFound, HttpStatus.NOT_FOUND);
    }
}
