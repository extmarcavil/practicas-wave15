package ar.com.mercadolibre.bootcamp.lfedele.covid19.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Sintoma{
    private String codigo;
    private String nombre;
    private Integer nivelDeGravedad;

    public Sintoma() {
    }

    public Sintoma(String codigo, String nombre, Integer nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }
}
