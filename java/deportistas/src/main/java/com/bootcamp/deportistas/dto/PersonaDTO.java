package com.bootcamp.deportistas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private Integer edad;
    private DeporteDTO deporte;

    public PersonaDTO(String nombre, String apellido, Integer edad, DeporteDTO deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporte = deporte;
    }
}
