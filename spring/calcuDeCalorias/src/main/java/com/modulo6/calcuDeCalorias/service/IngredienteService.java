package com.modulo6.calcuDeCalorias.service;

import com.modulo6.calcuDeCalorias.dto.IngredienteDTO;
import com.modulo6.calcuDeCalorias.dto.PlatoDTO;

import java.util.List;

public interface IngredienteService {

    PlatoDTO caloriasPlato(String nombre, Double peso);

    List<IngredienteDTO> getAllIngredientePlato(String nombre, Double peso);

    IngredienteDTO getIngredienteMayorCal(String nombre, Double peso);

}
