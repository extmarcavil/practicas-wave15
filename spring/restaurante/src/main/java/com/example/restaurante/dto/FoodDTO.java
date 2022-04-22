package com.example.restaurante.dto;

import com.example.restaurante.model.Alimento;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class FoodDTO {
    private double calTotal;
    private ArrayList<Alimento> alimentos;
    private Alimento alimentoMayorCalorias;

    public FoodDTO(double calTotal, ArrayList<Alimento> alimentos, Alimento alimentoMayorCalorias) {
        this.calTotal = calTotal;
        this.alimentos = alimentos;
        this.alimentoMayorCalorias = alimentoMayorCalorias;
    }
}
