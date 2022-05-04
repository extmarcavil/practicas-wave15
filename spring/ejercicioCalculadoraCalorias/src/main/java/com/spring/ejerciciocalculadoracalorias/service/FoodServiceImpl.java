package com.spring.ejerciciocalculadoracalorias.service;

import com.spring.ejerciciocalculadoracalorias.dto.InfoPlatoDTO;
import com.spring.ejerciciocalculadoracalorias.dto.IngredienteDTO;
import com.spring.ejerciciocalculadoracalorias.dto.PlatoDTO;
import com.spring.ejerciciocalculadoracalorias.model.Food;
import com.spring.ejerciciocalculadoracalorias.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService{

    private final FoodRepository repository;

    public FoodServiceImpl(FoodRepository repository) {
        this.repository = repository;
    }

    @Override
    public InfoPlatoDTO getInfoPlato(PlatoDTO plato, Double peso) {
        InfoPlatoDTO infoPlato = new InfoPlatoDTO();
        infoPlato.

    }
}
