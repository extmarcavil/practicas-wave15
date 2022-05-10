package calculadora.calorias.service;

import calculadora.calorias.dto.FoodDTO;
import calculadora.calorias.repository.MealsRepositoryInterface;
import org.springframework.stereotype.Service;

@Service
public class MealService implements IMeals {

    MealsRepositoryInterface mealsRepository;

    public MealService(MealsRepositoryInterface mealsRepository) {
        this.mealsRepository = mealsRepository;
    }

    @Override
    public FoodDTO getCalories(String mealName) {
        int calories = this.mealsRepository.getCalories(mealName);
        return new FoodDTO(mealName,calories);
    }
}
