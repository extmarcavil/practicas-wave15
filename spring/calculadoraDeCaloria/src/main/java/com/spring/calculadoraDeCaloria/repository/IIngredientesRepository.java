package com.spring.calculadoraDeCaloria.repository;

import com.spring.calculadoraDeCaloria.DTO.ComidasDTO;
import com.spring.calculadoraDeCaloria.DTO.IngredientesDTO;

import java.util.List;

public interface IIngredientesRepository {
    int getTotalCalorias(ComidasDTO comida);
    List<IngredientesDTO> getIngredientes(ComidasDTO comida);
    IngredientesDTO getMaxCal(ComidasDTO comida);
}
