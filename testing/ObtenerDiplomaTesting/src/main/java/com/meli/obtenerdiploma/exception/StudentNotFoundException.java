package com.meli.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;

public class StudentNotFoundException extends ObtenerDiplomaException {

    public StudentNotFoundException(Long id) {
        super("El alumno con Id " + id + " no se encuetra registrado.", HttpStatus.NOT_FOUND);
    }
}
