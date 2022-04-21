package com.bootcamp.covid19.repository;

import com.bootcamp.covid19.model.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SymptomRepository implements ISymptomRepository {
    static List<Symptom> listSymptom;
    static {
        listSymptom = new ArrayList<>();
        listSymptom.add(new Symptom("1","Fiebre",1));
        listSymptom.add(new Symptom("2","Dolor de cabeza",2));
        listSymptom.add(new Symptom("3","Miocarditis",5));
        listSymptom.add(new Symptom("4","Agotamiento",3));
    }

    @Override
    public List<Symptom> findSymptom(){
        return listSymptom;
    }

    @Override
    public Symptom findSymptomByName(String name){
        return listSymptom.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

}
