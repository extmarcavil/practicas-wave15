package com.ejercicio.calculadoracalorias.repository;

import com.ejercicio.calculadoracalorias.dto.IngredienteDTO;
import com.ejercicio.calculadoracalorias.dto.PlatoDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface IPlatoRepository {

    Optional<IngredienteDTO> findIngredientByName(String query );

    List<IngredienteDTO> findAllIngredients(String query);

    List<PlatoDTO> loadPlato();
}
