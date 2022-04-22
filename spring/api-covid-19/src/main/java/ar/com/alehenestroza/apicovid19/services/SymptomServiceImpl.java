package ar.com.alehenestroza.apicovid19.services;

import ar.com.alehenestroza.apicovid19.models.Symptom;
import ar.com.alehenestroza.apicovid19.repositories.SymptomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SymptomServiceImpl implements SymptomService {
    private final SymptomRepository symptomRepository;

    @Override
    public List<Symptom> findSymptoms() {
        return this.symptomRepository.getSymptoms();
    }

    @Override
    public Symptom findSymptom(String name) {
        return this.symptomRepository.getSymptom(name);
    }
}
