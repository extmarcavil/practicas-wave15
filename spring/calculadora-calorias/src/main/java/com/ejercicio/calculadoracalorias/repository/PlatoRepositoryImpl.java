package com.ejercicio.calculadoracalorias.repository;

import com.ejercicio.calculadoracalorias.dto.IngredienteDTO;
import com.ejercicio.calculadoracalorias.dto.PlatoDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class PlatoRepositoryImpl implements  IPlatoRepository {

    private final List<IngredienteDTO> database;

    public PlatoRepositoryImpl () {
        this.database = loadDataBase();
    }

    @Override
    public Optional<IngredienteDTO> findIngredientByName(String query ) {
        return database.stream()
                .filter(ingredienteDTO -> ingredienteDTO.getName().equals(query)).findFirst();
    }

    private List<IngredienteDTO> loadDataBase () {
        /*File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper  objectMapper = new ObjectMapper();
        TypeReference<List<IngredienteDTO>> typeRef = new TypeReference<>() {
        };
        List<IngredienteDTO> characters  = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
        */

        List<IngredienteDTO> listaIngredientes = new ArrayList<>();
        listaIngredientes.add(new IngredienteDTO("Fideos", 100));
        listaIngredientes.add(new IngredienteDTO("Ajo", 50));
        listaIngredientes.add(new IngredienteDTO("Berenjena", 200));
        listaIngredientes.add(new IngredienteDTO("Calabacin", 300));
        listaIngredientes.add(new IngredienteDTO("Aceituna", 400));
        listaIngredientes.add(new IngredienteDTO("Tomates", 250));
        listaIngredientes.add(new IngredienteDTO("Queso", 610));
        listaIngredientes.add(new IngredienteDTO("Oregano", 20));

        return listaIngredientes;

    }

    @Override
    public List<IngredienteDTO> findAllIngredients(String query) {
        return database.stream()
                .filter(characterDTO -> matchWith(query, characterDTO))
                .collect(Collectors.toList());
    }

    private boolean matchWith(String query, IngredienteDTO ingredienteDTO) {
        return ingredienteDTO.getName().toUpperCase().contains(query.toUpperCase());
    }

    public List<PlatoDTO> loadPlato(){
        List<PlatoDTO> platoDTOS = new ArrayList<>();

        List<IngredienteDTO> lista1 = new ArrayList<>();
        List<IngredienteDTO> lista2 = new ArrayList<>();
        List<IngredienteDTO> lista3 = new ArrayList<>();
        List<IngredienteDTO> lista4 = new ArrayList<>();
        List<IngredienteDTO> lista5 = new ArrayList<>();
        List<IngredienteDTO> lista6 = new ArrayList<>();
        List<IngredienteDTO> lista7 = new ArrayList<>();

        lista1.add(new IngredienteDTO("Aceituna" , 400));
        lista1.add(new IngredienteDTO("Queso Muzarella", 1000));
        lista1.add(new IngredienteDTO("Pure de tomate", 300));
        lista2.add(new IngredienteDTO("Fideos", 100));
        lista2.add(new IngredienteDTO("Pure de tomate", 200));
        lista3.add(new IngredienteDTO("Arroz", 250));
        lista4.add(new IngredienteDTO("Maiz", 1200));
        lista5.add(new IngredienteDTO("Sorrentinos", 600));
        lista5.add(new IngredienteDTO("Salsa blanca", 150));
        lista6.add(new IngredienteDTO("Zanahoria", 10));
        lista6.add(new IngredienteDTO("Cebolla", 60));
        lista7.add(new IngredienteDTO("Queso Muzarella", 1000));
        lista7.add(new IngredienteDTO("Tapa Empanada", 450));
        platoDTOS.add(new PlatoDTO("Fideos con tuco", lista2));
        platoDTOS.add(new PlatoDTO("Pizza", lista1));
        platoDTOS.add(new PlatoDTO("Sorrentinos con Salsa blanca", lista5));
        platoDTOS.add(new PlatoDTO("Verduras Mixtas", lista6));
        platoDTOS.add(new PlatoDTO("Empanada de Queso", lista7));

        return platoDTOS;
    }
}
