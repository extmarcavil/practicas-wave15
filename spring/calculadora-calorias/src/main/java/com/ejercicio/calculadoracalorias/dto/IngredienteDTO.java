package com.ejercicio.calculadoracalorias.dto;

public class IngredienteDTO {


    private String name;
    private  int calories;

    public IngredienteDTO( String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public IngredienteDTO(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalorias(int calorias) {
        this.calories = calorias;
    }

    @Override
    public String toString() {
        return "IngredienteDTO{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
}
