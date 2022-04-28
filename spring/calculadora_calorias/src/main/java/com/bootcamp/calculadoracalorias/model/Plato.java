package com.bootcamp.calculadoracalorias.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Plato {
    String nombre;
    List<Ingrediente> ingredientes;

}
