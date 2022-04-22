package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.model.Ingrediente;
import com.example.calculadoracalorias.model.Plato;
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

@Repository
public class CalculadoraCaloriasRepository implements ICalculadoraCaloriasRepository{
    private List<Ingrediente> database;
    private List<Plato> databasePlatos;

    public CalculadoraCaloriasRepository() {
        this.database = loadDataBase();
        this.databasePlatos = initDataPlatos();
    }

    private List<Ingrediente> loadDataBase () {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef      = new TypeReference<>() {
        };
        List<Ingrediente>                ingredients   = null;
        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    private List<Plato> initDataPlatos(){
        List<Plato> platos = new ArrayList<>();

        Plato platoNuevo = new Plato();
        platoNuevo.setNombre("Spaghettis");
        List<Ingrediente> ingrs = new ArrayList<>();
        ingrs.add(database.get(0));
        ingrs.add(database.get(1));
        ingrs.add(database.get(2));
        platoNuevo.setIngredientes(ingrs);
        platos.add(platoNuevo);

        Plato platoNuevo2 = new Plato();
        platoNuevo2.setNombre("Pastel");
        List<Ingrediente> ingrs2 = new ArrayList<>();
        ingrs2.add(database.get(3));
        ingrs2.add(database.get(4));
        ingrs2.add(database.get(5));
        platoNuevo2.setIngredientes(ingrs2);
        platos.add(platoNuevo2);

        return platos;
    }

    @Override
    public Optional<Plato> getPlato(String nombre) {
        return databasePlatos.stream().filter(plato -> plato.getNombre().contains(nombre)).findFirst();
    }

}
