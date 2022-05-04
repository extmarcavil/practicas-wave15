package com.spring.ejerciciocalculadoracalorias.service;

import com.spring.ejerciciocalculadoracalorias.dto.InfoPlatoDTO;
import com.spring.ejerciciocalculadoracalorias.dto.IngredienteDTO;
import com.spring.ejerciciocalculadoracalorias.dto.PlatoDTO;

import java.util.List;

public interface FoodService {

    InfoPlatoDTO getInfoPlato(PlatoDTO plato, Double peso);
}
