package com.spring.calculadoraDeCaloria.service;

import com.spring.calculadoraDeCaloria.DTO.InfoComidaDTO;
import com.spring.calculadoraDeCaloria.DTO.IngredientesClienteDTO;

import java.util.List;

public interface IPedirPlatoService {
    InfoComidaDTO getInfoPlato (String name, int peso, List<IngredientesClienteDTO> listaIngredientes);
}
