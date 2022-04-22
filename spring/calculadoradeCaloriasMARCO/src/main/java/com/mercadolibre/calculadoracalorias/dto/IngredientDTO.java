package com.mercadolibre.calculadoracalorias.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientDTO {
  private String name;
  private Double calories;
  private Integer weight;

}
