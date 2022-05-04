package com.spring.ejerciciocalculadoracalorias.dto;

import com.spring.ejerciciocalculadoracalorias.model.Ingrediente;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InfoPlatoDTO {
    private String name;
    private Double totalCalorias;
    private List<IngredienteDTO> listaIngredientes;
    private IngredienteDTO ingredienteCalorico;


}
