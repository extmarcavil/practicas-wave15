package com.example.demo.service;

import com.example.demo.dto.PersonaDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImp implements PersonaService{

    @Override
    public ResponseDTO crearRespuesta (PersonaDTO persona){
        ResponseDTO respuesta = new ResponseDTO(persona,"Persona creada correctamente!");
        return respuesta;
    }
    @Override
    public ResponseDTO llamarExcepcion(){
        if(true){
                throw new NotFoundException("Determinado cliente");
        }
        return new ResponseDTO();
    }

    @Override
    public ResponseDTO llamarControllerAdvice() {
        if(true){
           int a = 10/0;
        }
        return new ResponseDTO();
    }


}
