package com.bootcamp.blog.exception;

import com.bootcamp.blog.dto.ErrorDTO;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceBlogs {

    @ExceptionHandler(ExistingBlockEntranceException.class)
    public ResponseEntity<ErrorDTO> existingIdBlog (ExistingBlockEntranceException e){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("id existente");
        errorDTO.setDescripcion(e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoFoudBlogException.class)
    public ResponseEntity<ErrorDTO> NotFoudBlog (NoFoudBlogException e){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("id no existente");
        errorDTO.setDescripcion(e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }



}
