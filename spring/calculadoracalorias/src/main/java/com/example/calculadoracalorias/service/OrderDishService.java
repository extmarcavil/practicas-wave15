package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.DTO.DishesDTO;
import com.example.calculadoracalorias.DTO.IngredientsClientDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderDishService implements IOrderDishService{

    @Override
    public DishesDTO getDishInfo(String name, double weight, List<IngredientsClientDTO> ingredients) {
        return null;
    }
}
