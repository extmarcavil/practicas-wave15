package ar.com.alehenestroza.apideportistas.services;

import ar.com.alehenestroza.apideportistas.dto.PersonDTO;
import ar.com.alehenestroza.apideportistas.models.Person;
import ar.com.alehenestroza.apideportistas.models.Sport;
import ar.com.alehenestroza.apideportistas.repositories.PersonRepository;
import ar.com.alehenestroza.apideportistas.repositories.SportRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository    personRepository;
    private final SportRepository     sportRepository;

    @Override
    public List<PersonDTO> findSportsPersons() {
        List<PersonDTO> persons = new ArrayList<>();

        for (Person person : personRepository.getPersons()) {
            Sport sport = this.sportRepository.getSport(person.getSportName());
            persons.add(new PersonDTO(person, sport));
        }
        return persons;
    }
}
