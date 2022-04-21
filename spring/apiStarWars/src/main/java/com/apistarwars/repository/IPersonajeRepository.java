package com.apistarwars.repository;

import com.apistarwars.dto.PersonajeDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonajeRepository {
    List<PersonajeDTO> buscarPersonaje(String nombre);
}
