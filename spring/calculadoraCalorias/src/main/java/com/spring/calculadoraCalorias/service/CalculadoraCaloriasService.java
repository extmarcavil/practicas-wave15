package com.spring.calculadoraCalorias.service;

import com.spring.calculadoraCalorias.dto.PlatoDTO;

public interface CalculadoraCaloriasService {

    PlatoDTO getPlato(String name, double peso);
}
