package ar.com.alehenestroza.apicovid19.services;

import ar.com.alehenestroza.apicovid19.dto.PersonDTO;
import ar.com.alehenestroza.apicovid19.models.Person;
import ar.com.alehenestroza.apicovid19.repositories.PersonRepository;
import ar.com.alehenestroza.apicovid19.repositories.SymptomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final SymptomRepository symptomRepository;

    public PersonServiceImpl(PersonRepository personRepository, SymptomRepository symptomRepository) {
        this.personRepository = personRepository;
        this.symptomRepository = symptomRepository;
        this.personRepository.getPersons().get(2).addSymptom(
                this.symptomRepository.getSymptom("tos")
        );
    }

    @Override
    public List<PersonDTO> findRiskPersons() {
        List<PersonDTO> riskPersons = new ArrayList<>();
        for (Person person : this.personRepository.getPersons()) {
            if (person.getAge() >= 60 && person.getSymptoms().size() >= 1) {
                riskPersons.add(new PersonDTO(person));
            }
        }
        return riskPersons;
    }
}
