package com.vparula.starwars.service;

import com.vparula.starwars.dto.PersonajeDTO;
import com.vparula.starwars.model.Personaje;

import java.util.List;

public interface IServicePersonaje {
    public List<PersonajeDTO> devuelvoPersonaje(String name);
}
