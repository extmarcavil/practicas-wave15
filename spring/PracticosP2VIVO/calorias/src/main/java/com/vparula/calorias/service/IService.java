package com.vparula.calorias.service;

import com.vparula.calorias.DTO.IngredienteDTO;

import java.util.List;

public interface IService {
    public int getCalorias(String namePlato);
    public IngredienteDTO getIngredients(String namePlato);
}
