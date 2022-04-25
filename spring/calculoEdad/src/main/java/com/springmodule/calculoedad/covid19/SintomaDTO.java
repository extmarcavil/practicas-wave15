package com.springmodule.calculoedad.covid19;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SintomaDTO implements Serializable {
    private long codigo;
    private String nombre;
    private int nivelDeGravedad;

    public SintomaDTO (Sintoma sint){
        this.codigo = sint.getCodigo();
        this.nivelDeGravedad = sint.getNivelDeGravedad();
        this.nombre = sint.getNombre();
    }
}
