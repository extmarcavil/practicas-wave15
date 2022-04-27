package com.calorias.spring.repository;

import com.calorias.spring.modelo.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CaloriaRepositoryImpl implements CaloriaRepository {

        private final List<Ingrediente> database;

        public CaloriaRepositoryImpl () {

            this.database = loadDataBase();
        }

        @Override
        public List<Ingrediente> loadDataBase () {
            File file = null;
            try {
                file = ResourceUtils.getFile("classpath:food.json");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<Ingrediente>> typeRef      = new TypeReference<>() {
            };
            List<Ingrediente>                ingredientes   = null;
            try {
                ingredientes = objectMapper.readValue(file, typeRef);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ingredientes;
        }

    public List<Ingrediente> getDatabase() {
        return database;
    }
}
