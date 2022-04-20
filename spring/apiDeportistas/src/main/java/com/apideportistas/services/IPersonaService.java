package com.apideportistas.services;
import com.apideportistas.model.Deporte;
import com.apideportistas.model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface IPersonaService {
    int agregarPersona(Persona persona);

    ArrayList<Persona> obtenerPersonas();

    Persona buscarPersonaNombre(String nombrePersona) throws Exception;

    Persona personabyId(int idPersona) throws Exception;
}
