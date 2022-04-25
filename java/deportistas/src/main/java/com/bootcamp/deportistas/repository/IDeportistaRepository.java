package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.dto.DeporteDTO;
import com.bootcamp.deportistas.dto.PersonaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDeportistaRepository {
    DeporteDTO getSportByName(String sportName);
    List<PersonaDTO> getSportsPersons();
    List<DeporteDTO> getSports();
}
