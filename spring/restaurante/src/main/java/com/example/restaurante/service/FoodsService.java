package com.example.restaurante.service;

import com.example.restaurante.dto.FoodDTO;
import com.example.restaurante.model.Alimento;
import com.example.restaurante.model.Plato;
import com.example.restaurante.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodsService {
    @Autowired
    private IFoodRepository foodRepository;

    public FoodDTO getFood(String name,double peso){
        Plato plato = foodRepository.getPlato(name,peso);
        //calcular calorias total y obtener el alimento mas grande
        double totalCalorias = 0;
        Alimento mayor = new Alimento();

        for(Alimento alimento: plato.getAlimentos()){
            double calorias = alimento.getCalories();

            if (calorias > mayor.getCalories()) mayor = alimento;

            totalCalorias+=calorias;
        }


        FoodDTO foodDTO = new FoodDTO(totalCalorias,plato.getAlimentos(),mayor);

        return foodDTO;
    }
}
