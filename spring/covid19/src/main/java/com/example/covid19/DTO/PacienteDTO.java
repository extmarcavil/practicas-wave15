package com.example.covid19.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class PacienteDTO {

    private Integer id;
    private String nombreCompleto;
    private Integer edad;
    private List<String> sintomas;

    public PacienteDTO() {
    }

    public PacienteDTO(Integer id, String nombreCompleto, Integer edad, List<String> sintomas) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.sintomas = sintomas;
    }

}
