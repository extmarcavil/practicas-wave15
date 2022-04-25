package ar.com.alehenestroza.apicalculadoracalorias.services;

import ar.com.alehenestroza.apicalculadoracalorias.models.Ingredient;
import ar.com.alehenestroza.apicalculadoracalorias.repositories.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;

    @Override
    public Integer getCalories(String name) {
        return this.foodRepository.getCalories(name);
    }

    @Override
    public List<Ingredient> getIngredients(String name) {
        return this.foodRepository.getIngredients(name);
    }

    @Override
    public Ingredient getMostCaloricIngredient(String name) {
        return this.foodRepository.getMostCaloricIngredient(name);
    }
}
