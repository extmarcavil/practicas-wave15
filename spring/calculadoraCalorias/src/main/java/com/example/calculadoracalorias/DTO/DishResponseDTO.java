package com.example.calculadoracalorias.DTO;

import com.example.calculadoracalorias.model.Ingredient;

public class DishResponseDTO extends DishDTO {
  private Integer calories;
  private Ingredient caloric;

  public DishResponseDTO(DishDTO dish) {
    this.setIngredients(dish.getIngredients());
    this.setName(dish.getName());
  }

  public Integer getCalories() {
    return calories;
  }

  public void setCalories(Integer calories) {
    this.calories = calories;
  }

  public Ingredient getCaloric() {
    return caloric;
  }

  public void setCaloric(Ingredient caloric) {
    this.caloric = caloric;
  }
}
