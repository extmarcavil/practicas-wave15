package com.meli.calculadoracalorias.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.calculadoracalorias.dto.eatDTO;
import com.meli.calculadoracalorias.dto.plateDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class plateRepository {

    private final List<plateDTO> database;
    private final List<eatDTO> listadoComidas;

    public plateRepository () {
        this.database = loadDataBase();
        this.listadoComidas = new ArrayList<>();
    }

    public List<eatDTO> obtainComidas () {
        eatDTO comida1 = new eatDTO("Plato1", Arrays.asList(database.get(1), database.get(5)));
    }

    public List<plateDTO> findAll () {
        return database;
    }

    private List<plateDTO> loadDataBase () {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:3.food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<plateDTO>> typeRef      = new TypeReference<>() {
        };
        List<plateDTO>                plates   = null;
        try {
            plates = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return plates;
    }
}
