package com.mercadolibre.calculadoracalorias.dto.response;


import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;
import com.mercadolibre.calculadoracalorias.dto.request.DishDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DishResponseDTO extends DishDTO {
  private Double        calories;
  private IngredientDTO caloric;

  public DishResponseDTO ( String name, List<IngredientDTO> ingredients, Double calories, IngredientDTO caloric ) {
    super(name, ingredients);
    this.calories = calories;
    this.caloric  = caloric;
  }

  public DishResponseDTO() {
  }

}
