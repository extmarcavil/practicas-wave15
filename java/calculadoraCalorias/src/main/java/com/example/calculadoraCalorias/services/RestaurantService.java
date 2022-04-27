package com.example.calculadoraCalorias.services;

import com.example.calculadoraCalorias.dto.DtoIngrediente;
import com.example.calculadoraCalorias.dto.DtoPlatos;
import com.example.calculadoraCalorias.repository.IngredientRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService implements  IService {


    //Inyeccion de dependencia
    IngredientRepo repository;
    public RestaurantService(IngredientRepo repository){
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
