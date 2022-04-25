package com.bootcamp.calculadoradecalorias.repository;

import com.bootcamp.calculadoradecalorias.model.Plato;

import java.util.List;

public interface ICalculadoraRepository {
    Plato getPlato(String name);
    List<Plato> getPlatos();
}
