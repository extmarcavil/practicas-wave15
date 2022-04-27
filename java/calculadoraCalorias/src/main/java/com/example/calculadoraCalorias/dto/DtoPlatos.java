package com.example.calculadoraCalorias.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DtoPlatos {
    String nombre;
    List<DtoIngrediente> DTOIngredientes;

}
