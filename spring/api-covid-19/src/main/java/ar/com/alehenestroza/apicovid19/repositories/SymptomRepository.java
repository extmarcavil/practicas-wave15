package ar.com.alehenestroza.apicovid19.repositories;

import ar.com.alehenestroza.apicovid19.models.Symptom;

import java.util.List;

public interface SymptomRepository {
    List<Symptom> getSymptoms();
    Symptom getSymptom(String name);
}
