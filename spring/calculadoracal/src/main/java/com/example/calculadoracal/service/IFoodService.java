package com.example.calculadoracal.service;

import com.example.calculadoracal.dto.FoodInfoDTO;
import com.example.calculadoracal.dto.FoodRequestDTO;

import java.util.List;

public interface IFoodService {
    FoodInfoDTO findFoodInfo(String name, Integer weight);
    List<FoodInfoDTO> findFoodListInfo(List<FoodRequestDTO> foodRequestDTO);
}
