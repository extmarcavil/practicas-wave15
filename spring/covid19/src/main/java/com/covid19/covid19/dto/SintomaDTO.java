package com.covid19.covid19.dto;

import com.covid19.covid19.model.Sintoma;
import com.covid19.covid19.repository.Sintomas;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
public class SintomaDTO implements Serializable {
    private String codigo;
    private String nombre;
    private int nivel_de_gravedad;

    public SintomaDTO() {
    }

    public SintomaDTO(Sintoma sintoma) {
        if(sintoma != null){
            this.codigo = sintoma.getCodigo();
            this.nombre = sintoma.getNombre();
            this.nivel_de_gravedad = sintoma.getNivel_de_gravedad();
        }else{
            this.codigo = "No existe";
            this.nombre = "Esta enfermedad";
            this.nivel_de_gravedad = 0;
        }
    }

    public SintomaDTO(String codigo, String nombre, int nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }
}
