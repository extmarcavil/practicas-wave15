package com.covid.covid.dto;

import lombok.*;
import java.util.ArrayList;

@Getter
@Setter
public class PacienteDTO {
    String nombre;
    String apellido;
    ArrayList<SintomaDTO> listaSintomas;

    public PacienteDTO(String nombre, String apellido, ArrayList<SintomaDTO> listaSintomas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.listaSintomas = listaSintomas;
    }
}
