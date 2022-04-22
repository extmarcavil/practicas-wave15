package searcher.covid.service;

import searcher.covid.dto.PersonDTO;

import java.util.ArrayList;

public interface PersonServiceInterface {
    ArrayList<PersonDTO> getAllPersonsInRiskGroup();
}
