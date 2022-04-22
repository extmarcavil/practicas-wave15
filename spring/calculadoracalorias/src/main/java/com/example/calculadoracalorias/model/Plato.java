package com.example.calculadoracalorias.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Plato {
    private String nombre;
    private List<Ingrediente> ingredientes;
}
