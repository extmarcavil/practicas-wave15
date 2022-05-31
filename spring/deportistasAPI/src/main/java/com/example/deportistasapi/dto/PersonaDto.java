package com.example.deportistasapi.dto;

import com.example.deportistasapi.model.Persona;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PersonaDto {
    private String nombre;
    private String apellido;
    private List<DeporteDto> deportes;

    public PersonaDto() {
    }

    public PersonaDto(Persona persona) {
        this.nombre = persona.getNombre();
        this.apellido = persona.getApellido();
        this.deportes = persona.getDeportes()
                .stream()
                .map(DeporteDto::new)
                .collect(Collectors.toList());
    }
}
