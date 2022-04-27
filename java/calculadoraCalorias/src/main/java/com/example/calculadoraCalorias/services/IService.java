package com.example.calculadoraCalorias.services;

import com.example.calculadoraCalorias.dto.DtoIngrediente;

import java.util.List;

public interface IService {
    Double getCantidadCalorias();
    List<DtoIngrediente> getIngredientes ();


}
