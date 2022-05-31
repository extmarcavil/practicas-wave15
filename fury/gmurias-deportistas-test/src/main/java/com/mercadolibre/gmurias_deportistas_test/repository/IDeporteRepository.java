package com.mercadolibre.gmurias_deportistas_test.repository;


import com.mercadolibre.gmurias_deportistas_test.dtos.DeporteDTO;
import com.mercadolibre.gmurias_deportistas_test.dtos.PersonaDTO;

import java.util.List;
import java.util.Optional;

public interface IDeporteRepository {

    List<DeporteDTO> listarDeportes();
    Optional<DeporteDTO> listarDeportePorNombre(String nombre);
    List<PersonaDTO> listarDeportistas();

}
