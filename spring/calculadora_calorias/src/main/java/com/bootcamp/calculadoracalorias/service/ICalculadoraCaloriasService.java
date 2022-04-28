package com.bootcamp.calculadoracalorias.service;

import com.bootcamp.calculadoracalorias.dto.PlatoDTO;

public interface ICalculadoraCaloriasService {
    PlatoDTO getInfoPlato(String nombre, Integer peso);
}
