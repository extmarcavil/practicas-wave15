package com.starwars.starwars.servicio;

import com.starwars.starwars.dto.PersonajeDTO;
import com.starwars.starwars.repository.PersonajeRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonajeServicioImpl implements PersonajeServicio{
    PersonajeRepositorio personajeRepositorio;

    public PersonajeServicioImpl(PersonajeRepositorio personajeRepositorio){
        this.personajeRepositorio = personajeRepositorio;
    }

    @Override
    public List<PersonajeDTO> getPersonajesPorNombre(String nombre) {
        return personajeRepositorio.getPersonajesPorNombre(nombre);
    }
}
