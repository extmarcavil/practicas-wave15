package com.bootcamp.deportistas.dtos;

import com.bootcamp.deportistas.models.Deporte;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeporteDTO {

    private String nombre;
    private String nivel;

    public DeporteDTO(Deporte deporte) {
        this.nombre = deporte.getNombre();
        this.nivel = deporte.getNivel();
    }

}
