package com.spring.calculadoraDeCaloria.service;

import com.spring.calculadoraDeCaloria.DTO.response.InfoComidaDTO;
import com.spring.calculadoraDeCaloria.DTO.request.IngredientesClienteDTO;

import java.util.List;

public interface IPedirPlatoService {
    InfoComidaDTO getInfoPlato (String name, int peso, List<IngredientesClienteDTO> listaIngredientes);
}
