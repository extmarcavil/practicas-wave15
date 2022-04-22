package calculadora.calorias.model;

import java.util.List;

public class Meal {

    String name;
    List<Ingredient> listaDeIngredientes;

    public Meal(String nombre , List<Ingredient> listaDeIngredientes) {
        this.name = nombre;
        this.listaDeIngredientes = listaDeIngredientes;
    }

    public boolean hasName(String nombreDelPlato) {
        return name.equals(nombreDelPlato);
    }

    public int getCalories() {
        return listaDeIngredientes
                .stream()
                .mapToInt(Ingredient::getCalories)
                .sum();
    }
}
