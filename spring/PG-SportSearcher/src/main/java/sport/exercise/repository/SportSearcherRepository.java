package sport.exercise.repository;

import org.springframework.stereotype.Repository;
import sport.exercise.dto.PersonDTO;
import sport.exercise.dto.SportDTO;
import sport.exercise.model.Person;
import sport.exercise.model.Sport;
import sport.exercise.service.PersonServiceInterface;
import sport.exercise.service.SportServiceInterface;

import java.util.ArrayList;
import java.util.Arrays;

@Repository
public class SportSearcherRepository implements SportsSearcherInterface {

    ArrayList<Sport> listOfSavedSports;
    ArrayList<Person> listOfPersonWhoDoSports;

    public SportSearcherRepository() {
        this.initialize();
    }

    private void initialize() {
        listOfSavedSports = new ArrayList<>(Arrays.asList(
                new Sport("Tenis",1),
                new Sport("Futbol",2),
                new Sport("Natacion",3)
                ));

        listOfPersonWhoDoSports = new ArrayList<>(Arrays.asList(
                new Person("Pablo","Rago",50),
                new Person("Natalia","Oreiro",45),
                new Person("Segio","Denis",65)
        ));
    }

    @Override
    public ArrayList<Person> getAllPersonsWhoDoSports() {
        return (ArrayList<Person>) listOfPersonWhoDoSports.clone();
    }

    @Override
    public ArrayList<Sport> getAllSports() {
        return (ArrayList<Sport>) listOfSavedSports.clone();
    }

    @Override
    public Sport getSport(String name) {
        return listOfSavedSports
                .stream()
                .filter(x->x.hasName(name))
                .findFirst()
                .orElse(new Sport("Desconocido",0));
    }
}
