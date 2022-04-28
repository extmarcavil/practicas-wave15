package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.DTO.DishesDTO;
import com.example.calculadoracalorias.DTO.IngredientsClientDTO;

import java.util.List;


public interface IOrderDishService {
    DishesDTO getDishInfo(String name, double weight, List<IngredientsClientDTO> ingredients);
}
