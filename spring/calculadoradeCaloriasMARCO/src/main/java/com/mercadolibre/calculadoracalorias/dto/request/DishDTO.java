package com.mercadolibre.calculadoracalorias.dto.request;

import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DishDTO {
  private String              name;
  private List<IngredientDTO> ingredients;

  public DishDTO ( String name, List<IngredientDTO> ingredients ) {
    this.name        = name;
    this.ingredients = ingredients;
  }

  public DishDTO () {

  }
}
