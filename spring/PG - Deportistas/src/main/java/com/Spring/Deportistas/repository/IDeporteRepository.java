package com.Spring.Deportistas.repository;

import com.Spring.Deportistas.dto.DeporteDTO;
import com.Spring.Deportistas.dto.PersonaDTO;

import java.util.List;
import java.util.Optional;

public interface IDeporteRepository {

    List<DeporteDTO> listarDeportes();
    Optional<DeporteDTO> listarDeportePorNombre(String nombre);
    List<PersonaDTO> listarDeportistas();

}
