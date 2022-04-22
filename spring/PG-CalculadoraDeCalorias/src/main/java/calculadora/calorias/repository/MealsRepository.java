package calculadora.calorias.repository;

import calculadora.calorias.model.Ingredient;
import calculadora.calorias.model.Meal;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class MealsRepository implements IMealsRepository {
    private final List<Ingredient> listOfIngredients;
    private final List<Meal> listOfMeals;


    public MealsRepository() {
        this.listOfIngredients = loadIngredientList();
        this.listOfMeals = loadMeals();
    }

    private List<Meal> loadMeals() {

        Ingredient aceitunasNegras = new Ingredient("Aceitunas negras",349);
        Ingredient quesoDeOveja = new Ingredient("Queso de Oveja",245);
        Ingredient cafe = new Ingredient("Cafe",1);
        Ingredient magdalena = new Ingredient("Magdalena",469);


        ArrayList<Meal> listOfAvailableMeals = new ArrayList<>(
                Arrays.asList(
                        new Meal("Pizza",Arrays.asList(aceitunasNegras,quesoDeOveja)),
                        new Meal("Cafe",Arrays.asList(cafe,magdalena))
                )
        );

        return listOfAvailableMeals;
    }

    @Override
    public int getCalories(String mealNameToSearch) {
       Meal unPlato =this.listOfMeals
               .stream()
               .filter(aMeal->aMeal.hasName(mealNameToSearch))
               .findFirst()
               .orElse(new Meal("Desconocido",new ArrayList<Ingredient>() ));

       return unPlato.getCalories();
    }

    private List<Ingredient> loadIngredientList() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:json/food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper  objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};

        List<Ingredient> ingredients = null;
        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }
}
