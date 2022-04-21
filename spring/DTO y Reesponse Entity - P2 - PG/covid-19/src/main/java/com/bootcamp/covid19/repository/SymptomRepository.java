package com.bootcamp.covid19.repository;

import com.bootcamp.covid19.dtos.SymptomDTO;
import com.bootcamp.covid19.model.Symptom;

import java.util.ArrayList;
import java.util.List;

public class SymptomRepository {
    static List<Symptom> listSymptom;
    static {
        listSymptom = new ArrayList<>();
        listSymptom.add(new Symptom("1","Fiebre",1));
        listSymptom.add(new Symptom("2","Dolor de cabeza",2));
        listSymptom.add(new Symptom("3","Miocarditis",5));
        listSymptom.add(new Symptom("4","Agotamiento",3));
    }

    public List<SymptomDTO> findSymptom(){
        List<SymptomDTO> symptoms = new ArrayList<>();
        for (Symptom symptom : listSymptom) {
            symptoms.add(new SymptomDTO(symptom));
        }
        return symptoms;
    }

    public SymptomDTO findSymptomByName(String name){
        Symptom symptom = listSymptom.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .orElse(null);

        return symptom != null ? new SymptomDTO(symptom) : null;
    }


}
