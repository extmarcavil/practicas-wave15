package com.spring.calculadoraDeCaloria.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.calculadoraDeCaloria.DTO.ComidasDTO;
import com.spring.calculadoraDeCaloria.DTO.IngredientesDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class IngredientesRepository implements IIngredientesRepository{



    private List<IngredientesDTO> loadDataBase () {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientesDTO>> typeRef      = new TypeReference<>() {
        };
        List<IngredientesDTO> ingredientes   = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }

    @Override
    public int getTotalCalorias(ComidasDTO comida) {
        return 0;
    }

    @Override
    public List<IngredientesDTO> getIngredientes(ComidasDTO comida) {
        return null;
    }

    @Override
    public IngredientesDTO getMaxCal(ComidasDTO comida) {
        return null;
    }
}
