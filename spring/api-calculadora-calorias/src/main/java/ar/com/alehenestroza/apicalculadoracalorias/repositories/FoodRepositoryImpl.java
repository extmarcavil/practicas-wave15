package ar.com.alehenestroza.apicalculadoracalorias.repositories;

import ar.com.alehenestroza.apicalculadoracalorias.models.Dish;
import ar.com.alehenestroza.apicalculadoracalorias.models.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Repository
public class FoodRepositoryImpl implements FoodRepository {
    private final List<Ingredient> ingredients;
    private final List<Dish> dishes;

    public FoodRepositoryImpl() {
        this.ingredients = loadIngredients();
        this.dishes = new ArrayList<>(
                Arrays.asList(
                        new Dish(
                                "Pizza",
                                Arrays.asList(ingredients.stream().filter(p -> {
                                    return p.getName().equalsIgnoreCase("Salsa de tomate en conserva") ||
                                            p.getName().equalsIgnoreCase("Queso mozzarella") ||
                                            p.getName().equalsIgnoreCase("Harina de trigo refinada");
                                }).toArray(Ingredient[]::new))),
                        new Dish(
                                "Fideos",
                                Arrays.asList(ingredients.stream().filter(p -> {
                                    return p.getName().equalsIgnoreCase("Harina de trigo refinada") ||
                                            p.getName().equalsIgnoreCase("Huevo entero");
                                }).toArray(Ingredient[]::new))),
                        new Dish(
                                "Ensalada",
                                Arrays.asList(ingredients.stream().filter(p -> {
                                    return p.getName().equalsIgnoreCase("Lechuga") ||
                                            p.getName().equalsIgnoreCase("Tomate") ||
                                            p.getName().equalsIgnoreCase("Cebolla");
                                }).toArray(Ingredient[]::new)))
                )
        );
    }

    private static List<Ingredient> loadIngredients() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:ingredients.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeReference = new TypeReference<>() {
        };
        List<Ingredient> ingredients = null;
        try {
            ingredients = mapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    private Dish getDish(String name) {
        return dishes.stream().filter(p -> {
            return p.getName().equalsIgnoreCase(name);
        }).findFirst().orElse(null);
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public Integer getCalories(String name) {
        Dish dish = getDish(name);
        if (dish != null) {
            return dish.getCalories();
        }
        return null;
    }

    @Override
    public List<Ingredient> getIngredients(String name) {
        Dish dish = getDish(name);
        if (dish != null) {
            return dish.getIngredients();
        }
        return null;
    }

    @Override
    public Ingredient getMostCaloricIngredient(String name) {
        Dish dish = getDish(name);
        Ingredient ingredient = null;
        if (dish != null) {
            ingredient = dish.getIngredients().stream().max(Comparator.comparing(Ingredient::getCalories)).orElse(null);
        }
        return ingredient;
    }
}
