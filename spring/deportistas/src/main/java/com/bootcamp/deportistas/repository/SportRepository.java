package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.model.Person;
import com.bootcamp.deportistas.model.Sport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SportRepository implements ISportRepository{

    List<Sport> sports;
    List<Person> people;

    public SportRepository() {
    }

    public SportRepository(List<Sport> sports, List<Person> people) {
        this.sports = sports;
        this.people = people;
        data();
    }

    public void data(){

        Sport voleyball = new Sport("Voleyball", "trainee");
        Sport football = new Sport("Football", "pro");
        Sport basketball = new Sport("Basketball", "amateur");
        Sport handball = new Sport("Handball", "trainee");

        Person juan = new Person("Juan", "Rodriguez", 23);
        Person valentina = new Person("Valentina", "Perez", 18);
        Person luisina = new Person("Luisina", "Lopez", 29);
        Person pablo = new Person("Pablo", "Martinez", 32);

    }

    @Override
    public List<Sport> getAllSports() { return sports; }

    @Override
    public Optional<Sport> getSportByName(String name) {
        return sports.stream().filter(sport -> sport.getName().equals(name)).findFirst();
    }

    @Override
    public List<Person> getPeople() {
        return people;
    }
}
