package com.mercadolibre.calculadoracalorias.controller;

import com.mercadolibre.calculadoracalorias.dto.request.DishDTO;
import com.mercadolibre.calculadoracalorias.dto.response.DishResponseDTO;
import com.mercadolibre.calculadoracalorias.service.DishService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculateRestController {
  private final DishService dishService;

  public CalculateRestController(DishService dishService) {
    this.dishService = dishService;
  }

  @PostMapping("/calculate")
  public DishResponseDTO calculate(@RequestBody DishDTO dish){
    return dishService.calculateCalories(dish);
  }

  @PostMapping("/calculateAll")
  public List<DishResponseDTO> calculate(@RequestBody List<DishDTO> dishes){
    return dishService.calculateAllCalories(dishes);
  }
}