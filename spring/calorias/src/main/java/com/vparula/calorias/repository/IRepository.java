package com.vparula.calorias.repository;

import com.vparula.calorias.model.Ingrediente;
import com.vparula.calorias.model.Plato;

import java.util.List;

public interface IRepository {
    public Plato getCaloriasPlato (String plato);
    public List<Ingrediente> getIngredientesPlato(String plato);
}
