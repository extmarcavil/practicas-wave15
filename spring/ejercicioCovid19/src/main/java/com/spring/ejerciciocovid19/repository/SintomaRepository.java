package com.spring.ejerciciocovid19.repository;

import com.spring.ejerciciocovid19.dtos.Persona;
import com.spring.ejerciciocovid19.dtos.SintomaDTO;
import com.spring.ejerciciocovid19.model.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SintomaRepository implements ISintomaRepository {
    List<SintomaDTO> sintomas;
    List<Persona> personas;

    public SintomaRepository() {
        sintomas = new ArrayList<>();
        personas = new ArrayList<>();
        initData();
    }

    public List<SintomaDTO> getAllSintomas() {
        return sintomas;
    }

    public Optional<SintomaDTO> getSintomaByName(String name) {
        return sintomas.stream()
                .filter(sintoma -> sintoma.getName().equals(name))
                .findFirst();
    }

    private void initData() {
        Sintoma fiebre = new Sintoma("F1", "Fiebre", 2);
        Sintoma sinOlfato = new Sintoma("O1", "Falta de olfato", 3);
        Sintoma dolorMuscular = new Sintoma("D1", "Dolor muscular general", 2);
        Sintoma faltaAire = new Sintoma("F2", "Dificultad para respirar", 1);


    }
}
