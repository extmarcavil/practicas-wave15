package com.modulo6.covid19.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PacienteDTO {

    private String nombre;
    private String apellido;
    private List<SintomaDTO> sintomas;

    public PacienteDTO(String nombre, String apellido, List<SintomaDTO> sintomas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sintomas = sintomas;
    }

    public PacienteDTO() {

    }

    @Override
    public String toString() {
        return "PacienteDTO{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", sintomas=" + sintomas +
                '}';
    }
}
