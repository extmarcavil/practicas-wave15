package com.bootcamp.covid.repository;

import com.bootcamp.covid.model.Symptom;

import java.util.ArrayList;
import java.util.List;


public class SymptomRepository {
    public static List<Symptom> listSymptom = new ArrayList<>();

    static {
        listSymptom.add(new Symptom("CVD1","Tos","Bajo"));
        listSymptom.add(new Symptom("CVD2","Fiebre","Medio"));
        listSymptom.add(new Symptom("CVD3","Cansancio","alto"));
        listSymptom.add(new Symptom("CVD4","Perdida del Olfato/Gusto","Alto"));
    }
}
