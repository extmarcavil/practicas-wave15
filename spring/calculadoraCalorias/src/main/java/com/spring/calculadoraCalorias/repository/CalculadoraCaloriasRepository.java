package com.spring.calculadoraCalorias.repository;

import com.spring.calculadoraCalorias.model.Plato;

public interface CalculadoraCaloriasRepository {

    Plato getPlato(String name, double peso);
}
