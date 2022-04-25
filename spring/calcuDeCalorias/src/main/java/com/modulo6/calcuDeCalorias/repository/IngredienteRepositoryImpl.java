package com.modulo6.calcuDeCalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.modulo6.calcuDeCalorias.dto.IngredienteDTO;
import com.modulo6.calcuDeCalorias.dto.PlatoDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredienteRepositoryImpl implements IngredienteRepository {

    private final List<IngredienteDTO> database;

    public IngredienteRepositoryImpl() {
        this.database = loadDataBase();
    }


    private List<IngredienteDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredienteDTO>> typeRef = new TypeReference<>() {};
        List<IngredienteDTO> priceDTOS = null;
        try {
            priceDTOS = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return priceDTOS;
    }



    @Override
    public List<IngredienteDTO> getAll() {
        return database;
    }

    public List<PlatoDTO> datosPlato(){

        List<PlatoDTO> platos = new ArrayList<PlatoDTO>();
        List<IngredienteDTO> ip1 = new ArrayList<IngredienteDTO>();
        List<IngredienteDTO> ip2 = new ArrayList<IngredienteDTO>();
        ip1.add(this.getAll().get(1));
        ip1.add(this.getAll().get(10));
        ip2.add(this.getAll().get(3));
        ip2.add(this.getAll().get(12));

        PlatoDTO p1 =new PlatoDTO("fideos", ip1, 300.6D);
        PlatoDTO p2 =new PlatoDTO("milanesas" , ip2, 256.8D);

        platos.add(p1);
        platos.add(p2);

        return platos;
    }


    @Override
    public List<PlatoDTO> getAllPlato() {

        return datosPlato();
    }

    @Override
    public PlatoDTO plato(String nombre, Double peso) {

        PlatoDTO plato = getAllPlato().stream()
                .filter(plato1 -> plato1.getName().equals(nombre) && plato1.getPeso().equals(peso))
                .findFirst()
                .orElse(null);
        return plato;
    }


}
