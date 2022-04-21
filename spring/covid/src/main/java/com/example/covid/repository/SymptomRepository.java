package com.example.covid.repository;

import com.example.covid.dto.SymptomDTO;
import com.example.covid.models.Person;
import com.example.covid.models.Symptom;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Getter
@Setter
public class SymptomRepository implements ISymptomRepository{
    List<Symptom> symptoms = new ArrayList<>();
    List<Person> persons = new ArrayList<>();

    public SymptomRepository() {
        Symptom s1 = new Symptom(1, "Tos", 4);
        Symptom s2 = new Symptom(2, "Fiebre", 5);
        Symptom s3 = new Symptom(3, "Cansancio", 3);
        Symptom s4 = new Symptom(4, "Dolores musculares", 4);
        this.symptoms.add(s1);
        this.symptoms.add(s2);
        this.symptoms.add(s3);
        this.symptoms.add(s4);

        Person p1 = new Person(1, "Wendy", "Sclerandi", 27, Arrays.asList(s1, s2));
        Person p2 = new Person(2, "Alejandro", "Barsotti", 65, Arrays.asList(s2, s4));
        Person p3 = new Person(3, "Rafael", "Perez", 70);
        this.persons.add(p1);
        this.persons.add(p2);
        this.persons.add(p3);
    }

    @Override
    public List<SymptomDTO> getAllSymptoms(){
        List<SymptomDTO> symptomsDTO = new ArrayList<>();
        for (Symptom symptom : symptoms){
            SymptomDTO symptomDTO = new SymptomDTO();
            symptomDTO.setName(symptom.getName());
            symptomDTO.setSeverityLevel(symptom.getSeverityLevel());
            symptomsDTO.add(symptomDTO);
        }
        return symptomsDTO;
    }

    @Override
    public Optional<SymptomDTO> getSymptomByName(String name){
        return this.getAllSymptoms().stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public List<Person> getRiskPersons(){
        return persons.stream()
                .filter(p -> p.isOld() && p.hasSymptoms())
                .collect(Collectors.toList());
    }
}
