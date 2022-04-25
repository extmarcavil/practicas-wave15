package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.dto.DeporteDTO;
import com.bootcamp.deportistas.dto.PersonaDTO;

import java.util.List;

public interface IDeportistaService {
    DeporteDTO getSportDTO(String sportName);
    List<PersonaDTO> getSportsPersons();
    List<DeporteDTO> getSports();
}
