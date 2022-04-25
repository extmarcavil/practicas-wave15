package com.bootcamp.deportistas.dtos;

import com.bootcamp.deportistas.models.Deporte;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonaDTO {

    private String nombre;
    private String apellido;
    private List<String> listDeportes;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate fechaNacimiento;

    public PersonaDTO(String nombre, String apellido, List<String> listDeportes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.listDeportes = listDeportes;
    }
}
