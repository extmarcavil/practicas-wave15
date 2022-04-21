package com.apistarwars.service;

import com.apistarwars.dto.PersonajeDTO;
import com.apistarwars.repository.IPersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService implements IPersonajeService {
    //region Variables
    private IPersonajeRepository _personajeRepository;
    //endregion

    //region Constructor

    public PersonajeService(IPersonajeRepository personajeRepository) {
        this._personajeRepository = personajeRepository;
    }

    //endregion

    //region Implementacion

    @Override
    public List<PersonajeDTO> likeByNombre(String nombre)
    {
        if(!nombre.isBlank() || !nombre.isEmpty())
            return  _personajeRepository.buscarPersonaje(nombre);
        else
            return null;
    }

    //endregion
}
