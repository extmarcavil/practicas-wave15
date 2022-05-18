package com.example.blog.exception;

public class IdNotFoundException extends RuntimeException{

    public IdNotFoundException(int id) {
        super("No se ha encontrado el link: " + id);
    }

}
