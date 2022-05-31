package com.example.deportistasapi.dto;

import com.example.deportistasapi.model.Deporte;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeporteDto {
    private String nombre;

    public DeporteDto() {}

    public DeporteDto(Deporte deporte) {
        this.nombre = deporte.getNombre();
    }
}
