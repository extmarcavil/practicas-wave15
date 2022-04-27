package com.example.calculadoraCalorias.repository;

import com.example.calculadoraCalorias.dto.DtoIngrediente;
import com.example.calculadoraCalorias.modelo.Ingredient;

import java.util.List;

public interface IngredientRepo {
   List<DtoIngrediente> getIngredientes();
}
