package com.vparula.calorias.service;

import com.vparula.calorias.DTO.IngredienteDTO;
import com.vparula.calorias.model.Ingrediente;

import java.util.List;

public interface IService {
    public int getCalorias(String namePlato);
    public List<IngredienteDTO> getIngredients(String namePlato);
    public IngredienteDTO getIngredienteCalorico(String namePlato);
}
