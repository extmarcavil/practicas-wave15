package com.ejercicio.calculadoracalorias.dto;
import java.util.List;

public class PlatoDTO {

    private String nombre;
    List<IngredienteDTO> ingredientes;

    public PlatoDTO( String nombre, List<IngredienteDTO> ingredientes) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
    }

    public PlatoDTO(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<IngredienteDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "PlatoDTO{" +
                "nombre='" + nombre + '\'' +
                ", ingredientes=" + ingredientes +
                '}';
    }
}
