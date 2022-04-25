package com.spring.calculadoraCalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.calculadoraCalorias.model.Ingrediente;
import com.spring.calculadoraCalorias.model.Plato;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class CalculadoraCaloriasImpl implements CalculadoraCaloriasRepository {

    private List<Plato> platos;
    private List<Ingrediente> ingredientes;

    public CalculadoraCaloriasImpl() {
        this.platos = new ArrayList<>();
        this.ingredientes = new ArrayList<>();
        loadDataBase();
    }

    @Override
    public Plato getPlato(String name, double peso) {
        return platos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(name) && p.getPeso() == peso)
                .findFirst()
                .orElse(null);
    }

    public void loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<ArrayList<Ingrediente>> typeRef = new TypeReference<>() {
        };

        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Ingrediente> ingredientesPlato1 = new ArrayList<>();

        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            int value = r.nextInt(ingredientes.size() - 1 + i) + i;

            Ingrediente ingrediente = ingredientes.get(value);
            ingredientesPlato1.add(ingrediente);
        }

        Plato p1 = new Plato("Fideos con tuco", ingredientesPlato1, 200.5);
        ArrayList<Ingrediente> ingredientesPlato2 = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int value = r.nextInt(ingredientes.size() - 1 + i) + i;

            Ingrediente ingrediente = ingredientes.get(value);
            ingredientesPlato2.add(ingrediente);
        }

        Plato p2 = new Plato("empanada", ingredientesPlato2, 300.5);

        platos.add(p1);
        platos.add(p2);
    }
}
