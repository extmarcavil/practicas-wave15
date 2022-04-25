package com.spring.deportistas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDeportistaDTO {

    private String nombre;
    private String apellido;
    private String deporte;

    public PersonaDeportistaDTO(String nombre, String apellido, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
    }
}
