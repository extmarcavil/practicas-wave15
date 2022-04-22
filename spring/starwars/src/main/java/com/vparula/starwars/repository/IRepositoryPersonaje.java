package com.vparula.starwars.repository;

import com.vparula.starwars.model.Personaje;

import java.util.List;
import java.util.Optional;

public interface IRepositoryPersonaje {
    List<Personaje> getPersonajeByName (String name );
}
