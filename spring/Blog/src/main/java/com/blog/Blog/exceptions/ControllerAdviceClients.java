package com.blog.Blog.exceptions;


import com.blog.Blog.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceClients {

    @ExceptionHandler(ExisteBlogException.class)
    public ResponseEntity<ErrorDTO> blogExisteExceptionHandler(ExisteBlogException blogExiste) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("ID Already taken");
        errorDTO.setDescription(blogExiste.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> notFoundHandler(NotFoundException notFound) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("No se encontró entrada");
        errorDTO.setDescription(notFound.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
}

