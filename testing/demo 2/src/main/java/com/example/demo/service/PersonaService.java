package com.example.demo.service;

import com.example.demo.dto.PersonaDTO;
import com.example.demo.dto.ResponseDTO;

public interface PersonaService {
    public ResponseDTO crearRespuesta (PersonaDTO persona);
    ResponseDTO llamarExcepcion();

    ResponseDTO llamarControllerAdvice();
}
