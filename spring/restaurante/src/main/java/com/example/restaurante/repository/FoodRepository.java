package com.example.restaurante.repository;

import com.example.restaurante.model.Alimento;
import com.example.restaurante.model.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class FoodRepository implements IFoodRepository{
    private ArrayList<Alimento> alimentos;
    private ArrayList<Plato> platos = new ArrayList<>();

    public FoodRepository(){
        loadDataBase();
    }

    public void loadDataBase(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<ArrayList<Alimento>> typeRef = new TypeReference<>(){};

        try {
            alimentos = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Alimento> alimentosPlato1 = new ArrayList<>();

        Random r = new Random();
        for (int i = 0; i < 3; i++){
            int value = r.nextInt(alimentos.size()- 1  + i) + i;

            Alimento alimento = alimentos.get(value);
            alimentosPlato1.add(alimento);
        }

        Plato p1 = new Plato("Fideos con tuco",200.5,alimentosPlato1);
        ArrayList<Alimento> alimentosPlato2 = new ArrayList<>();

        for (int i = 0; i < 3; i++){
            int value = r.nextInt(alimentos.size()- 1  + i) + i;

            Alimento alimento = alimentos.get(value);
            alimentosPlato2.add(alimento);
        }

        Plato p2 = new Plato("empanada",300.5,alimentosPlato2);

        platos.add(p1);
        platos.add(p2);
    }


    @Override
    public Plato getPlato(String name, double peso) {
        return platos.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name) && p.getPeso() == peso)
                .findFirst()
                .orElse(null);
    }
}
