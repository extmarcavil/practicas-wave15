package com.bootcamp.calculadoradecalorias.repository;

import com.bootcamp.calculadoradecalorias.model.Ingrediente;
import com.bootcamp.calculadoradecalorias.model.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CalculadoraRepository implements ICalculadoraRepository {

    private final List<Ingrediente> ingredientes;
    private final List<Plato> listPlatos;


    public CalculadoraRepository() {
        this.ingredientes = loadDataBase();
        this.listPlatos = loadPlatos();
    }

    private List<Plato> loadPlatos() {
        List<Plato> platos = new ArrayList<>();
        List<Ingrediente> ingredientes = new ArrayList<>();
        ingredientes.add(getIngrediente("Acelgas"));
        ingredientes.add(getIngrediente("Ajos"));
        ingredientes.add(getIngrediente("Naranja"));
        ingredientes.add(getIngrediente("Cebolla"));

        platos.add(new Plato("Tamal", ingredientes));
        ingredientes.clear();

        ingredientes.add(getIngrediente("Berenjena"));
        ingredientes.add(getIngrediente("Conejo"));
        ingredientes.add(getIngrediente("Berros"));
        ingredientes.add(getIngrediente("Calabaza"));

        platos.add(new Plato("Arroz con pollo", ingredientes));

        return platos;
    }

    private Ingrediente getIngrediente(String ingrediente){
        return ingredientes.stream().filter(i -> i.getName().equals(ingrediente) ).findFirst().orElse(null);
    }


    private List<Ingrediente> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<java.util.List<Ingrediente>> typeRef = new TypeReference<>() {
        };
        List<Ingrediente> ingredientes = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }

    @Override
    public Plato getPlato(String name) {
        return null;
    }

    @Override
    public List<Plato> getPlatos() {
        return null;
    }
}
