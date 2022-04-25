package com.covid19.dto;

import com.covid19.model.Sintoma;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SintomaDTO {

    private String codigo;
    private String nombre;
    private int nivel_de_gravedad;

    public SintomaDTO(String codigo, String nombre, int nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    public SintomaDTO(Sintoma sintoma) {
        this.codigo = sintoma.getCodigo();
        this.nombre = sintoma.getNombre();
        this.nivel_de_gravedad = sintoma.getNivel_de_gravedad();
    }
}
