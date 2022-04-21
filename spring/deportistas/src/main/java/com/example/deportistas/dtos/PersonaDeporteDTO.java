package com.example.deportistas.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PersonaDeporteDTO {
    private String nombre;
    private String apellido;
    private List<NombreDeporteDTO> deportes;
}
