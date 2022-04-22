package sport.exercise.service;

import org.springframework.stereotype.Service;
import sport.exercise.dto.PersonDTO;
import sport.exercise.dto.SportDTO;
import sport.exercise.model.Person;
import sport.exercise.model.Sport;
import sport.exercise.repository.SportsSearcherInterface;

import java.util.ArrayList;

@Service
public class PersonService implements PersonServiceInterface{

    SportsSearcherInterface sportRepository;

    public PersonService(SportsSearcherInterface sportRepository) {
        this.sportRepository = sportRepository;
    }

    @Override
    public ArrayList<PersonDTO> getAllPersonsWhoDoSports() {
        ArrayList<PersonDTO> listOfPersonDTO = new ArrayList<>();
        ArrayList<Person> listOfSports = this.sportRepository.getAllPersonsWhoDoSports();
        for( Person eachPerson : listOfSports ){
            listOfPersonDTO.add(new PersonDTO(eachPerson));
        }
        return (ArrayList<PersonDTO>) listOfPersonDTO.clone();
    }
}
