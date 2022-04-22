package com.spring.calculadoraDeCaloria.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ComidasDTO {
    private String name;
    private List<IngredientesDTO> ingredientes;
    private int peso;


}
