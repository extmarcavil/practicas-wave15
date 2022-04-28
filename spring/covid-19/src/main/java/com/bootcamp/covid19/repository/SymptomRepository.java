package com.bootcamp.covid19.repository;

import com.bootcamp.covid19.model.Symptom;
import com.bootcamp.covid19.dto.SymptomDTO;

import java.util.ArrayList;
import java.util.List;

public class SymptomRepository {
    static List<Symptom> listSymptom = new ArrayList<>();
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

    public Symptom findSymptomByName(String name){
        return listSymptom.stream()
                .filter(symptom -> symptom.getName().equals(name))
                .findFirst()
                .orElse(null);
    }


}
