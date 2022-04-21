package com.bootcamp.covid19.service;

import com.bootcamp.covid19.dtos.PatientDTO;
import com.bootcamp.covid19.dtos.SymptomDTO;
import com.bootcamp.covid19.model.Person;
import com.bootcamp.covid19.model.Symptom;
import com.bootcamp.covid19.repository.ISymptomRepository;
import com.bootcamp.covid19.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CovidService implements ICovidService{

    ISymptomRepository symptomRepository;
    PersonRepository personRepository;

    public CovidService(PersonRepository personRepository, ISymptomRepository symptomRepository){
        this.personRepository = personRepository;
        this.symptomRepository = symptomRepository;
    }

    @Override
    public List<SymptomDTO> findSymptom(){
        List<SymptomDTO> symptoms = new ArrayList<>();
        //Mapeo
        List<Symptom> s = symptomRepository.findSymptom();
        for (Symptom symptom : s) {
            symptoms.add(new SymptomDTO(symptom));
        }
        return symptoms;
    }

    @Override
    public SymptomDTO findSymptomByName(String name){
        Symptom symptom = symptomRepository.findSymptomByName(name);
        return symptom != null ? new SymptomDTO(symptom) : null;
    }

    @Override
    public List<PatientDTO> findRiskPerson(){
        List<Person> listPersons = personRepository.findRiskPerson();
        //Mapeo
        List<PatientDTO> listPatientsDto = new ArrayList<>();
        for (Person person : listPersons) {
            List<String> symptoms = new ArrayList<>();
            for(Symptom symptom : person.getListSymptom()){
                symptoms.add(symptom.getName());
            }
            listPatientsDto.add(new PatientDTO(person.getName() +" "+ person.getLastName(), person.getAge(), symptoms));
        }
        return listPatientsDto;
    }

}
