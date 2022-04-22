package com.spring.calculadoraDeCaloria.repository;

import com.spring.calculadoraDeCaloria.DTO.ComidasDTO;
import com.spring.calculadoraDeCaloria.DTO.request.IngredientesClienteDTO;
import com.spring.calculadoraDeCaloria.DTO.response.IngredientesDTO;
import com.spring.calculadoraDeCaloria.model.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IIngredientesRepository {
    Optional<Ingredient> findIngredient (String name);
}
