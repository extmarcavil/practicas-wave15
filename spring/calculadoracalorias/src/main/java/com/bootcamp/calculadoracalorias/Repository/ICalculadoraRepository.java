package com.bootcamp.calculadoracalorias.Repository;

import com.bootcamp.calculadoracalorias.DTO.IngredientesDTO;

import java.util.Optional;

public interface ICalculadoraRepository {
    Optional<IngredientesDTO> ingredientesDto(String query);
}
