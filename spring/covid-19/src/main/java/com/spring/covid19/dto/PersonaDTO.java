package com.spring.covid19.dto;

import com.spring.covid19.model.Sintoma;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PersonaDTO {

    private String nombre;
    private String apellido;
    private List<Sintoma> sintomas;

    public PersonaDTO(String nombre, String apellido, List<Sintoma> sintomas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sintomas = sintomas;
    }
}
