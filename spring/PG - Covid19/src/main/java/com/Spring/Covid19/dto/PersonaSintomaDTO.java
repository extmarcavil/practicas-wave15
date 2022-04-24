package com.Spring.Covid19.dto;

import com.Spring.Covid19.model.Sintoma;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonaSintomaDTO {
    private String nombre;
    private String apellido;
    private List<SintomaDTO> sintomas;

    public PersonaSintomaDTO(String nombre, String apellido, List<SintomaDTO> sintomas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sintomas = sintomas;
    }
}
