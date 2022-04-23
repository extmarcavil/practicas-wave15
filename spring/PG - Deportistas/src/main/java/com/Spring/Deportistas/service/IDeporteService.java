package com.Spring.Deportistas.service;

import com.Spring.Deportistas.dto.DeporteDTO;
import com.Spring.Deportistas.dto.PersonaDeportistaDTO;

import java.util.List;

public interface IDeporteService {

    List<DeporteDTO> listarDeportes();
    DeporteDTO listarDeporteDTO(String nombre);
    List<PersonaDeportistaDTO> listarDeportistas();
}
