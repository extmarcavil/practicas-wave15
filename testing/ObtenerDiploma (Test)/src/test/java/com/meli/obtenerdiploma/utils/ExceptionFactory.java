package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.ErrorDTO;

public class ExceptionFactory {
    public static ErrorDTO studentNotFoundException(Long id) {
        return new ErrorDTO("StudentNotFoundException", "El alumno con Id " + id + " no se encuetra registrado.");
    }
}
