package com.bootcamp.calculadoracalorias.Service;

import com.bootcamp.calculadoracalorias.DTO.IngredientesDTO;
import com.bootcamp.calculadoracalorias.Repository.ICalculadoraRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class CalculadoraService implements ICalculadoraService{

    ICalculadoraRepository repository;

    public CalculadoraService(ICalculadoraRepository repository) {
        this.repository = repository;
    }


}
