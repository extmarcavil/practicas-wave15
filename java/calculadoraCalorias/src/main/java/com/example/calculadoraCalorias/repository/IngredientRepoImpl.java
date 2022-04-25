package com.example.calculadoraCalorias.repository;

import com.example.calculadoraCalorias.dto.DtoIngrediente;
import com.example.calculadoraCalorias.dto.DtoPlatos;
import com.example.calculadoraCalorias.modelo.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class IngredientRepoImpl implements IngredientRepo {

    //hacer lista database
    List<DtoIngrediente> database;
    List<DtoPlatos> platosDataBase;

    public IngredientRepoImpl(){
        database = new ArrayList<>();
        platosDataBase = new ArrayList<>();
        database = loadDataBase();
        iniPlatosDataBase();

    }

    public List<DtoIngrediente> getIngredientes(){
        return database;
    }

    //llamar al Json
    //Manera interna de cargar datos
    private List<DtoIngrediente> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<DtoIngrediente>> typeRef = new TypeReference<>() {};
        List<DtoIngrediente> priceDTOS = null;
        try {
            priceDTOS = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return priceDTOS;
    }

    public void iniPlatosDataBase(){
        DtoPlatos ensalada = new DtoPlatos();
        DtoPlatos frutillasConCrema = new DtoPlatos();
        DtoPlatos ensaladaDeFrutas = new DtoPlatos();

        DtoIngrediente lechuga = database.get(1);
        DtoIngrediente tomate = database.get(2);
        DtoIngrediente huevo = database.get(3);

        List<DtoIngrediente> arrayEnsalada = Arrays.asList(lechuga, tomate, huevo);
        this.platosDataBase.addAll(Arrays.asList(ensalada, frutillasConCrema, ensaladaDeFrutas));

        ensalada.setDTOIngredientes(arrayEnsalada);

    }

    public DtoPlatos getPlato(DtoPlatos plato){
        platosDataBase.forEach();

    }

}
