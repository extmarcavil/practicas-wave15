package com.meli.covid.controller;

import com.meli.covid.model.Symptom;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class findSymptom {
    @GetMapping("/findSymptom")
    public List<Symptom> symptom() {
        List<Symptom> symptoms = obtainSymptom();
        return symptoms;
    }

    @GetMapping("/findSymptom/{name}")
    public List<Symptom> verifySymptom(@PathVariable String name){
        List<Symptom> symptoms = obtainSymptom();
        List<Symptom> listFiltered = symptoms.stream()
                .filter (symptom -> name.equals (symptom.getName ()))
                .collect(Collectors.toList());
        if (listFiltered.size() == 0) return null;
        return listFiltered;
    }

    public List<Symptom> obtainSymptom () {
        List<Symptom> symptoms = new ArrayList<Symptom>();
        Symptom sympton1 = new Symptom(01, "Fiebre", "Leve");
        Symptom sympton2 = new Symptom(02, "Respiracion dificultosa", "Medio");
        Symptom sympton3 = new Symptom(03, "Fiebre alta persistente", "Grave");

        symptoms.add(sympton1);
        symptoms.add(sympton2);
        symptoms.add(sympton3);

        return symptoms;
    }


}
