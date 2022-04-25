package com.bootcamp.calculadoradecalorias.service;

import com.bootcamp.calculadoradecalorias.dto.PlatoCaloriasDTO;
import com.bootcamp.calculadoradecalorias.model.Plato;
import com.bootcamp.calculadoradecalorias.repository.CalculadoraRepository;
import com.bootcamp.calculadoradecalorias.repository.ICalculadoraRepository;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService implements ICalculadoraService {
    ICalculadoraRepository calculadoraRepository;

    public CalculadoraService(ICalculadoraRepository calculadoraRepository){

        this.calculadoraRepository = calculadoraRepository;
    }

    @Override
    public PlatoCaloriasDTO getPlato(String name, Integer peso) {

        return null;
    }
}
