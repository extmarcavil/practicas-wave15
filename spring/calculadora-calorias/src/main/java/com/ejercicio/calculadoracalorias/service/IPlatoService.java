package com.ejercicio.calculadoracalorias.service;

import com.ejercicio.calculadoracalorias.dto.IngredienteDTO;
import com.ejercicio.calculadoracalorias.dto.PlatoDTO;

import java.util.List;

public interface IPlatoService {

    List<IngredienteDTO> getAllIngredients(String query);

    String statsPlato(String name);
}
