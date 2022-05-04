package com.example.ejerciciorestaurante.exception;

public class RecipeNotFoundException extends RuntimeException {
    public RecipeNotFoundException(String name) {
        super(name);
    }
}
