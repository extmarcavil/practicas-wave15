package com.Spring.StarWars.service;

import com.Spring.StarWars.dto.PersonajeFiltradoDTO;

import java.util.List;

public interface IPersonajeService {

    List<PersonajeFiltradoDTO> listarPersonajesFiltrados(String filtro);

}
