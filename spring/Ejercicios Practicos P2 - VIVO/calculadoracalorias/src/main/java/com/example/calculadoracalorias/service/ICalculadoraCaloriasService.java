package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.PlatoMuestraDTO;

public interface ICalculadoraCaloriasService {
    PlatoMuestraDTO getInfoPlato(String nombre, Integer peso);
}
