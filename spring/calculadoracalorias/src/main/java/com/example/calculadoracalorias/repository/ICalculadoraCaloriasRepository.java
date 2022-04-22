package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.model.Plato;

import java.util.Optional;

public interface ICalculadoraCaloriasRepository {
    Optional<Plato> getPlato(String nombre);
}
