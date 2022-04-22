package searcher.covid.service;

import org.springframework.stereotype.Service;
import searcher.covid.repository.RepositoryInterface;
import searcher.covid.dto.SymptomDTO;
import searcher.covid.model.Symptom;

import java.util.ArrayList;

@Service
public class SymptomService implements SymptomServiceInterface {

    RepositoryInterface symptomsRepository;

    public SymptomService(RepositoryInterface symptomsRepository) {
        this.symptomsRepository = symptomsRepository;
    }

    @Override
    public ArrayList<SymptomDTO> getAllSymptoms() {
        ArrayList<SymptomDTO> listOfSymptomDTO = new ArrayList<>();
        ArrayList<Symptom> listOfSymptoms = this.symptomsRepository.getAllSymptoms();
        for( Symptom eachSymptom : listOfSymptoms){
            listOfSymptomDTO.add(new SymptomDTO(eachSymptom));
        }
        return (ArrayList<SymptomDTO>) listOfSymptomDTO.clone();
    }

    @Override
    public SymptomDTO getRiskLevelOf(String name) {
        Symptom aSymptom =  this.symptomsRepository.getRiskLevelOf(name);
        return new SymptomDTO(aSymptom);
    }
}
