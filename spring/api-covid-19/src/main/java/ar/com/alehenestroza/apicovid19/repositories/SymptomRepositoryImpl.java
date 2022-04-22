package ar.com.alehenestroza.apicovid19.repositories;

import ar.com.alehenestroza.apicovid19.models.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SymptomRepositoryImpl implements SymptomRepository {
    private List<Symptom> symptoms;

    public SymptomRepositoryImpl() {
        this.symptoms = new ArrayList<>(Arrays.asList(
                new Symptom("B1", "Dolor de cabeza", 3),
                new Symptom("A2", "Tos", 2),
                new Symptom("A1", "Fiebre", 1)
        ));
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public List<Symptom> getSymptoms() {
        return this.symptoms;
    }

    @Override
    public Symptom getSymptom(String name) {
        return this.symptoms.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
