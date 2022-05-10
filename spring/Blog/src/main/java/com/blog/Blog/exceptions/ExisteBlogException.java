package com.blog.Blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.ALREADY_REPORTED,reason = "Ya existe")
public class ExisteBlogException extends RuntimeException {

        public ExisteBlogException(String mensaje) {
            super(mensaje);
        }
}
