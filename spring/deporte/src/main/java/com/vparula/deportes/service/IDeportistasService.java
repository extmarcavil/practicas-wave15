package com.vparula.deportes.service;

import com.vparula.deportes.dtos.DeporteDTO;
import com.vparula.deportes.dtos.PersonaDTO;
import com.vparula.deportes.model.Deporte;

import java.util.List;

public interface IDeportistasService{

    List<DeporteDTO> getDeportes ();
    DeporteDTO getDeportesPorNombre ( String nombre );
    List<PersonaDTO> getDeportistas ();
}
