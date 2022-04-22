package com.mercadolibre.calculadoracalorias.service;

import com.mercadolibre.calculadoracalorias.dto.request.DishDTO;
import com.mercadolibre.calculadoracalorias.dto.response.DishResponseDTO;

import java.util.List;

public interface DishService {
  DishResponseDTO calculateCalories(DishDTO dish);

  List<DishResponseDTO> calculateAllCalories(List<DishDTO> dishes);
}
