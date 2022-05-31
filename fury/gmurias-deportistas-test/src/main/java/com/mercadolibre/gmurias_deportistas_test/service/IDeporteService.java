package com.mercadolibre.gmurias_deportistas_test.service;

import com.mercadolibre.gmurias_deportistas_test.dtos.DeporteDTO;
import com.mercadolibre.gmurias_deportistas_test.dtos.PersonaDeportistaDTO;

import java.util.List;

public interface IDeporteService {

    List<DeporteDTO> listarDeportes();
    DeporteDTO listarDeporteDTO(String nombre);
    List<PersonaDeportistaDTO> listarDeportistas();
}
