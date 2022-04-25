package com.modulo6.calcuDeCalorias.repository;

import com.modulo6.calcuDeCalorias.dto.PlatoDTO;
import com.modulo6.calcuDeCalorias.dto.IngredienteDTO;

import java.util.List;

public interface IngredienteRepository {

    List<IngredienteDTO> getAll();

    List<PlatoDTO> getAllPlato();

    PlatoDTO plato(String nombre, Double peso);


}
