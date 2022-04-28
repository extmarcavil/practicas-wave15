package com.bootcamp.calculadoradecalorias.service;

import com.bootcamp.calculadoradecalorias.dto.PlatoCaloriasDTO;

public interface ICalculadoraService {
    PlatoCaloriasDTO getPlato(String name, Integer peso);
}
