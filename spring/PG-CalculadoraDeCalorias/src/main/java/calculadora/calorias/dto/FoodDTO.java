package calculadora.calorias.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodDTO {

    String foodName;
    int mealCalories;

    public FoodDTO(String foodName, int mealCalories) {
        this.foodName = foodName;
        this.mealCalories = mealCalories;
    }
}
