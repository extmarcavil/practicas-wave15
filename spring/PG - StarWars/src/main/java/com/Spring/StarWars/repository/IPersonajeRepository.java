package com.Spring.StarWars.repository;

import com.Spring.StarWars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeRepository {

    List<PersonajeDTO> buscarFiltrado(String filtro);

}
