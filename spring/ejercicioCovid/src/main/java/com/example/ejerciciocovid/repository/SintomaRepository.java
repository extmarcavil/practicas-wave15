package com.example.ejerciciocovid.repository;

import com.example.ejerciciocovid.model.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class SintomaRepository {

    private static List<Sintoma> sintomas;
    static {
        sintomas = new ArrayList<Sintoma>();
        sintomas.add(new Sintoma(1, "Golpe en el pie", "Bajo"));
        sintomas.add(new Sintoma(2, "Dolor de muela", "Medio"));
        sintomas.add(new Sintoma(3, "Covid", "Alto"));
    }

    public SintomaRepository() {
    }

    public List<Sintoma> getSintomasList() {
        return sintomas;
    }
}
