package calculadora.calorias.repository;


import calculadora.calorias.model.Ingredient;

import java.util.List;

public interface MealsRepositoryInterface {
  int getCalories(String plato);
}
