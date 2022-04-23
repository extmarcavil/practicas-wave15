package ar.com.mercadolibre.bootcam.calorias.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingrediente {
    private String nombre;
    private Integer calorias;

    public Ingrediente() {}

    public Ingrediente(String nombre, Integer calorias) {
        this.nombre = nombre;
        this.calorias = calorias;
    }
}
