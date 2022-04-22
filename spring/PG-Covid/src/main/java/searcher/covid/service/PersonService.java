package searcher.covid.service;

import org.springframework.stereotype.Service;
import searcher.covid.repository.RepositoryInterface;
import searcher.covid.dto.PersonDTO;
import searcher.covid.model.Person;

import java.util.ArrayList;

@Service
public class PersonService implements PersonServiceInterface{

    RepositoryInterface symptomsRepository;

    public PersonService(RepositoryInterface symptomsRepository) {
        this.symptomsRepository = symptomsRepository;
    }

    @Override
    public ArrayList<PersonDTO> getAllPersonsInRiskGroup() {
        ArrayList<PersonDTO> listOfPersonDTO = new ArrayList<>();
        ArrayList<Person> listOfSports = this.symptomsRepository.getAllPersonsInRiskGroup();
        for( Person eachPerson : listOfSports ){
            listOfPersonDTO.add(new PersonDTO(eachPerson));
        }
        return (ArrayList<PersonDTO>) listOfPersonDTO.clone();
    }
}
