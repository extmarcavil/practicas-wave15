package ar.com.alehenestroza.apicovid19.services;

import ar.com.alehenestroza.apicovid19.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    List<PersonDTO> findRiskPersons();
}
