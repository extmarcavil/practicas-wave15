package calculadora.calorias.model;

import calculadora.calorias.dto.MappeableToDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingredient implements MappeableToDTO {

    String name;
    int calories;

    public Ingredient(){}

    public Ingredient(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    @Override
    public void mapToDTO(Object aDTO) {
    }

    public int getCalories() {
        return calories;
    }
}
