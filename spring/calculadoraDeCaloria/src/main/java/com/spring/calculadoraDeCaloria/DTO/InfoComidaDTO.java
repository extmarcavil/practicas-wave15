package com.spring.calculadoraDeCaloria.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class InfoComidaDTO {
    private int totalCalorias;
    private List<IngredientesDTO> listaIgredientes;
    private IngredientesDTO ingredienteMasCaloria;

}
