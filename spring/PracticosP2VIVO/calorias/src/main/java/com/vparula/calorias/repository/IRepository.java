package com.vparula.calorias.repository;

import com.vparula.calorias.model.Ingrediente;
import com.vparula.calorias.model.Plato;

import java.util.List;
import java.util.Optional;

public interface IRepository {
    public Optional<Plato> getCaloriasPlato (String plato);
    public List<Ingrediente> getIngredientesPlato(String plato);
}
