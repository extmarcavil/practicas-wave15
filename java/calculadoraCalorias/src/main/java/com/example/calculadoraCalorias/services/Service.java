package com.example.calculadoraCalorias.services;

import com.example.calculadoraCalorias.dto.DtoIngrediente;
import com.example.calculadoraCalorias.dto.DtoPlatos;
import com.example.calculadoraCalorias.repository.IngredientRepo;

import java.util.List;

@org.springframework.stereotype.Service
public class Service implements  IService {


    //Inyeccion de dependencia
    IngredientRepo repository;
    public Service( IngredientRepo repository){
        this.repository = repository;
    }

    @Override
    public Double getCantidadCalorias(DtoPlatos plato) {
        //¿Como deberia hacer para buscar los ingredientes correspondientes a ese plato?
    }

    @Override
    public List<DtoIngrediente> getIngredientes() {
        return repository.getIngredientes();
    }
}
