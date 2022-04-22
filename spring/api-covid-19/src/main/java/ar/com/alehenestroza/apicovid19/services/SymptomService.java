package ar.com.alehenestroza.apicovid19.services;

import ar.com.alehenestroza.apicovid19.models.Symptom;

import java.util.List;

public interface SymptomService {
    List<Symptom> findSymptoms();
    Symptom findSymptom(String name);
}
