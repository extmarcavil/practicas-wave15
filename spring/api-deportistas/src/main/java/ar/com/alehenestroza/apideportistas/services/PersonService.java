package ar.com.alehenestroza.apideportistas.services;

import ar.com.alehenestroza.apideportistas.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    List<PersonDTO> findSportsPersons();
}
