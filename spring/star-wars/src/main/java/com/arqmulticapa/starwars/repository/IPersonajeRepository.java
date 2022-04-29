package com.arqmulticapa.starwars.repository;


import com.arqmulticapa.starwars.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> findByNameContains(String name) ;
}
