package com.example.restaurante.repository;

import com.example.restaurante.model.Plato;

public interface IFoodRepository {
    public Plato getPlato(String name,double peso);
}
