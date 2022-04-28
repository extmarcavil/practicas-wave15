package com.bootcamp.calculadoracalorias.repository;

import com.bootcamp.calculadoracalorias.model.Plato;

public interface ICalculadoraCaloriasRepository {
    Plato getPlato(String nombre);
}
