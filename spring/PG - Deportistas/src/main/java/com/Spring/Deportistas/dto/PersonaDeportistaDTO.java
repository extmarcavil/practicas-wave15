package com.Spring.Deportistas.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonaDeportistaDTO {
    private String nombre;
    private String apellido;
    private List<DeporteDTO> deportes;

    public PersonaDeportistaDTO(String nombre, String apellido, List<DeporteDTO> deportes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deportes = deportes;
    }
}
