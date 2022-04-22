package com.mercadolibre.calculadoracalorias.service;

import com.mercadolibre.calculadoracalorias.dto.request.DishDTO;
import com.mercadolibre.calculadoracalorias.dto.response.DishResponseDTO;
import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;
import com.mercadolibre.calculadoracalorias.model.Dish;
import com.mercadolibre.calculadoracalorias.model.Ingredient;
import com.mercadolibre.calculadoracalorias.repositories.IngredientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements DishService {
    private final IngredientRepository ingredientRepository;

    ModelMapper mapper;

    public DishServiceImpl ( IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public DishResponseDTO calculateCalories ( DishDTO dish ) {

        Dish dish1 = mapper.map(dish, Dish.class);

        List<IngredientDTO> ingredients = dish.getIngredients()
          .stream()
          .map(this::calculateIngredientCalories)
          .collect(Collectors.toList());

        Double totalCalories = ingredients.stream()
          .mapToDouble(IngredientDTO::getCalories)
          .sum();
        /*.reduce(0D, ( acc, i ) -> acc + i.getCalories(), Double::sum);*/

        IngredientDTO caloricIngredient = ingredients.stream()
          .max(Comparator.comparing(IngredientDTO::getCalories))
          .orElse(null);

        return new DishResponseDTO(dish.getName(), ingredients, totalCalories, caloricIngredient);
    }

    @Override
    public List<DishResponseDTO> calculateAllCalories ( List<DishDTO> dishes ) {
        return dishes.stream()
          .map(this::calculateCalories)
          .collect(Collectors.toList());
    }

    private IngredientDTO calculateIngredientCalories ( IngredientDTO ingredientDTO ) {
        ingredientDTO.setCalories(0D);

        /* tiene dos atributos*/             /* tiene 5 atributos*/
        Ingredient ingredient1 = mapper.map(ingredientDTO, Ingredient.class);
        Ingredient ingredient2 = mapper.map(ingredientDTO, Ingredient.class);

        ingredientRepository.findIngredientByName(ingredientDTO.getName())
          .ifPresent(foundIngredient ->
            ingredientDTO.setCalories(( ingredientDTO.getWeight() * foundIngredient.getCalories() / 100D ))
          );

        IngredientDTO ingredientDTO = mapper.map(ingredient1, IngredientDTO.class);
        mapper.map(person, ingredientDTO);
        mapper.map(addres, ingredientDTO);
        return ingredientDTO;
    }
}
