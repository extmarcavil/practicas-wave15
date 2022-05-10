package calculadora.calorias.service;

import calculadora.calorias.dto.FoodDTO;

public interface IMeals {
    FoodDTO getCalories(String plato);


}
