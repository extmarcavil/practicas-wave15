package sport.exercise.service;

import sport.exercise.dto.PersonDTO;

import java.util.ArrayList;

public interface PersonServiceInterface {
    ArrayList<PersonDTO> getAllPersonsWhoDoSports();
}
