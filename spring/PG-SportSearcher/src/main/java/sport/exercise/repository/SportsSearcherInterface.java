package sport.exercise.repository;

import sport.exercise.model.Person;
import sport.exercise.model.Sport;

import java.util.ArrayList;

public interface SportsSearcherInterface {

     ArrayList<Person> getAllPersonsWhoDoSports();
     ArrayList<Sport> getAllSports();
     Sport getSport(String name);
}
