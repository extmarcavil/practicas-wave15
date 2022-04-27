package com.calorias.spring.service;

import com.calorias.spring.modelo.Ingrediente;
import com.calorias.spring.modelo.Plato;
import com.calorias.spring.repository.CaloriaRepository;
import com.calorias.spring.repository.CaloriaRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoService {

    private CaloriaRepositoryImpl caloriaRepositoryImpl;

    public PlatoService(CaloriaRepositoryImpl caloriaRepository) {
        this.caloriaRepositoryImpl = caloriaRepository;


    }

    public void getCalorias(String nombre, int peso) {
        List<Ingrediente> ingredienteList= caloriaRepositoryImpl.getDatabase();

        Plato plato = new Plato()

        for (Ingrediente ingrediente:ingredienteList) {
            System.out.println(ingrediente.getName());
        }


    }


}
