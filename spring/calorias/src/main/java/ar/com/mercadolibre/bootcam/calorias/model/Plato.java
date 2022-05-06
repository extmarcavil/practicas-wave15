package ar.com.mercadolibre.bootcam.calorias.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Plato {
    private String nombre;
    private List<Ingrediente> ingredientes;

    public Plato() {}

    public Plato(String nombre, List<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
    }
}
