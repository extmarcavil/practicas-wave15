package com.Spring.Covid19.repository;

import com.Spring.Covid19.dto.PersonaDTO;
import com.Spring.Covid19.dto.SintomaDTO;

import java.util.List;
import java.util.Optional;

public interface ICovid19Repository {

    List<SintomaDTO> listarSintomas();
    Optional<SintomaDTO> listarSintomaPorNombre(String nombre);
    List<PersonaDTO> listarSintomaticos();
}
