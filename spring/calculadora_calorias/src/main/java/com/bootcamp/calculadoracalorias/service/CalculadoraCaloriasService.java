package com.bootcamp.calculadoracalorias.service;

import com.bootcamp.calculadoracalorias.dto.PlatoDTO;
import com.bootcamp.calculadoracalorias.model.Plato;
import com.bootcamp.calculadoracalorias.repository.ICalculadoraCaloriasRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CalculadoraCaloriasService implements ICalculadoraCaloriasService{
    @Autowired
    ICalculadoraCaloriasRepository repository;

    @Override
    public PlatoDTO getInfoPlato(String nombre, Integer peso) {
        Plato plato = repository.getPlato(nombre);
        return null;
    }
}
