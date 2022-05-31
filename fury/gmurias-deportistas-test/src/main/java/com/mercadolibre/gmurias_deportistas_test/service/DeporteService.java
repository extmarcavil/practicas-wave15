package com.mercadolibre.gmurias_deportistas_test.service;

import com.mercadolibre.gmurias_deportistas_test.dtos.DeporteDTO;
import com.mercadolibre.gmurias_deportistas_test.dtos.PersonaDeportistaDTO;
import com.mercadolibre.gmurias_deportistas_test.repository.IDeporteRepository;
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
