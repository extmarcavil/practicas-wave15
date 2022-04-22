package com.vparula.deportes.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonaDTO {

    String nombre;
    String apellido;
    List<String> nombreDeportes;

    public PersonaDTO(String nombre, String apellido, List<String> nombreDeporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreDeportes = nombreDeporte;
    }
}
