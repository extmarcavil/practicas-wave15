package com.bootcamp.calculadoracalorias.repository;

import com.bootcamp.calculadoracalorias.model.Ingrediente;
import com.bootcamp.calculadoracalorias.model.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class CalculadoraCaloriasRepository implements ICalculadoraCaloriasRepository{

    private List<Ingrediente> database;

    public CalculadoraCaloriasRepository() {
        loadDataBase();
    }

    public List<Ingrediente> loadDataBase(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>(){};

        List<Ingrediente> ingredientes = null;
        try {
            objectMapper.readValue(file,typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }
        return ingredientes;
    }

    @Override
    public Plato getPlato(String nombre) {
        return null;
    }
}
