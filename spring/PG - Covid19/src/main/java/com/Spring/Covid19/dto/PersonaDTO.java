package com.Spring.Covid19.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonaDTO {

    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    List<SintomaDTO> sintomas;

    public PersonaDTO(Integer id, String nombre, String apellido, Integer edad, List<SintomaDTO> sintomas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomas = sintomas;
    }

    public boolean tieneSintomas(){
        return !this.sintomas.isEmpty();
    }

    public boolean esMayor(){
        return edad >= 60;
    }

}
