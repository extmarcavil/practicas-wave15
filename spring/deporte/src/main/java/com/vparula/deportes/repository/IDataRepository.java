package com.vparula.deportes.repository;

import com.vparula.deportes.dtos.PersonaDTO;
import com.vparula.deportes.model.Deporte;
import com.vparula.deportes.model.Persona;

import java.util.List;
import java.util.Optional;

public interface IDataRepository {

    List<Deporte> getAllDeportes ();
    Optional<Deporte> getDeportePorNombre (String nombre );
    List<Persona> getDeportistas ();
}
