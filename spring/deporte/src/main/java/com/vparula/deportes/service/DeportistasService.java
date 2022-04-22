package com.vparula.deportes.service;

import com.vparula.deportes.dtos.DeporteDTO;
import com.vparula.deportes.dtos.PersonaDTO;
import com.vparula.deportes.model.Deporte;
import com.vparula.deportes.repository.IDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeportistasService implements IDeportistasService{
    IDataRepository repositorio;

    public DeportistasService (  IDataRepository repositorio) {
        this.repositorio = repositorio;
    }
    @Override
    public List<DeporteDTO> getDeportes() {
        return repositorio.getAllDeportes().stream().map(deporte -> new DeporteDTO(deporte.getNombre(),deporte.getNivel())).collect(Collectors.toList());
    }

    @Override
    public DeporteDTO getDeportesPorNombre(String nombre) {
        try {
            Deporte deporte = repositorio.getDeportePorNombre(nombre)
                    .orElseThrow(() -> new RuntimeException("NOT FOUND"));
            return new DeporteDTO(deporte.getNombre(),deporte.getNivel());
        } catch (RuntimeException e) {
            return new DeporteDTO("ERROR", e.getMessage());
        }
    }

    @Override
    public List<PersonaDTO> getDeportistas() {
        return repositorio.getDeportistas().stream().map(persona -> new PersonaDTO(persona.getNombre(),persona.getApellido(), persona.devuelvoDeportes())).collect(Collectors.toList());

    }
}
