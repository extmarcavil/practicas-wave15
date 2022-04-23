package com.covid.EjercicioCovid19.dto;

import com.covid.EjercicioCovid19.model.Sintoma;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SintomaDTO implements Serializable {
    private Integer codigo;
    private String nombre;
    private Integer nivel_de_gravedad;

    public SintomaDTO(Integer codigo, String nombre, Integer nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }


/*public SintomaDTO() {
        Sintoma sintoma1 = new Sintoma(1,"fiebre",10);
        Sintoma sintoma2 = new Sintoma(2,"tos",2);
        listadoSintomas.add(sintoma1);
        listadoSintomas.add(sintoma2);
    }*/
}
