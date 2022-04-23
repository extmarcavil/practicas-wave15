package com.Spring.Deportistas.service;

import com.Spring.Deportistas.dto.DeporteDTO;
import com.Spring.Deportistas.dto.PersonaDTO;
import com.Spring.Deportistas.dto.PersonaDeportistaDTO;
import com.Spring.Deportistas.model.Deporte;
import com.Spring.Deportistas.repository.IDeporteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeporteService implements IDeporteService{

    IDeporteRepository repository;

    public DeporteService (IDeporteRepository repository){
        this.repository = repository;
    }

    public List<DeporteDTO> listarDeportes() {
        return repository.listarDeportes();
    }

    public DeporteDTO listarDeporteDTO(String nombre) {
        try {
            DeporteDTO deporte = repository.listarDeportePorNombre(nombre)
                    .orElseThrow(() -> new RuntimeException("NOT FOUND"));
            return deporte;
        }catch (RuntimeException e){
            return new DeporteDTO("ERROR", e.getMessage());
        }
    }

    public List<PersonaDeportistaDTO> listarDeportistas() {
        List<PersonaDeportistaDTO> deportistas = repository.listarDeportistas().stream()
                .map(deportista -> new PersonaDeportistaDTO(deportista.getNombre(), deportista.getApellido(), deportista.getDeportes()))
                .collect(Collectors.toList());
        return deportistas;
    }
}
